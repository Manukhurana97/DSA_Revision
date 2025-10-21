import os
import re
from collections import defaultdict

EXCLUDE_DIRS = {'.git', '.idea', '.vscode', '__pycache__'}
VALID_EXTENSIONS = {'.java', '.py'}

def count_files_per_folder(base_path='.'):
    """Return a dict mapping absolute folder path -> number of valid files directly in that folder."""
    folder_counts = defaultdict(int)
    base_abs = os.path.abspath(base_path)

    for dirpath, dirnames, filenames in os.walk(base_abs):
        dirnames[:] = [d for d in dirnames if d not in EXCLUDE_DIRS]
        folder_counts[dirpath] += sum(
            1 for f in filenames if os.path.splitext(f)[1] in VALID_EXTENSIONS
        )
    # Make sure base folder is present even if empty
    if base_abs not in folder_counts:
        folder_counts[base_abs] = 0
    return folder_counts

def compute_cumulative_counts(folder_counts):
    """
    Given folder_counts mapping (direct counts), compute cumulative counts:
    each folder's count becomes direct files + sum of all descendants' cumulative counts.
    """
    # start with direct counts copy
    cumulative = dict(folder_counts)

    # sort directories by depth (deepest first) so child counts propagate up to parents
    dirs_sorted = sorted(folder_counts.keys(), key=lambda p: p.count(os.sep), reverse=True)

    for d in dirs_sorted:
        parent = os.path.dirname(d)
        # only add to parent if parent is in our map (i.e., inside the scanned tree)
        if parent in cumulative and parent != d:
            cumulative[parent] += cumulative[d]
    return cumulative

def extract_number(name):
    match = re.search(r'(\d+)$', name)
    return int(match.group(1)) if match else float('inf')

def print_tree(folder_counts, cumulative_counts, base_path='.', prefix="", is_last=True, skip_root=False, level=0):
    """
    Print folder hierarchy using cumulative_counts for display.
    folder_counts is kept for any logic requiring direct counts (not necessary here).
    """
    base_abs = os.path.abspath(base_path)
    base_name = os.path.basename(base_abs) or base_abs
    if not skip_root:
        connector = "└── " if is_last else "├── "
        # use cumulative_counts for the displayed number
        print(f"{prefix}{connector}{base_name} ({cumulative_counts.get(base_abs, 0)} files)")

    entries = []
    for entry in sorted(os.listdir(base_abs), key=lambda x: extract_number(x)):
        full_path = os.path.join(base_abs, entry)
        if os.path.isdir(full_path) and entry not in EXCLUDE_DIRS:
            entries.append((entry, full_path))

    new_prefix = prefix + ("    " if is_last else "│   ")
    for i, (name, path) in enumerate(entries):
        last = (i == len(entries) - 1)
        print_tree(folder_counts, cumulative_counts, path, new_prefix, last, skip_root=False, level=level+1)
        # insert blank line ONLY between top-level siblings
        if level == 0 and not last:
            print()

def main():
    choice = input("Do you want full hierarchy (y/n)? ").strip().lower()
    base_path = '.'

    if choice == 'y':
        folder_counts = count_files_per_folder(base_path)
        cumulative_counts = compute_cumulative_counts(folder_counts)
        # print tree starting from base_path but skip printing the root name itself (like you had earlier)
        print_tree(folder_counts, cumulative_counts, base_path, "", True, skip_root=True, level=0)
    else:
        # old style: just top-level folders (show cumulative counts for top-level)
        folder_counts = count_files_per_folder(base_path)
        cumulative_counts = compute_cumulative_counts(folder_counts)

        counts = defaultdict(int)
        base_abs = os.path.abspath(base_path)
        root_name = os.path.basename(base_abs)
        for dirpath in folder_counts:
            rel_path = os.path.relpath(dirpath, base_abs)
            parts = rel_path.split(os.sep) if rel_path != '.' else []
            top_folder = parts[0] if parts else root_name
            counts[top_folder] += folder_counts[dirpath]  # direct counts aggregated per top-level

        # If you want the top-level totals to include nested files, use cumulative_counts on top-level dirs instead:
        print(f"{'Folder':<40} | {'File Count':>10}")
        print("-" * 55)
        total = 0
        # prepare top-level list: include the root itself and any immediate child dirs
        top_level_dirs = [root_name] + [d for d in os.listdir(base_abs) if os.path.isdir(os.path.join(base_abs, d)) and d not in EXCLUDE_DIRS]
        unique_top = []
        for t in top_level_dirs:
            if t not in unique_top:
                unique_top.append(t)

        for folder in sorted(unique_top, key=extract_number):
            if folder == root_name:
                cnt = cumulative_counts.get(base_abs, 0)
            else:
                folder_abs = os.path.join(base_abs, folder)
                cnt = cumulative_counts.get(os.path.abspath(folder_abs), 0)
            print(f"{folder:<40} | {cnt:>10}")
            total += cnt
        print("-" * 55)
        print(f"{'Total':<40} | {total:>10}")

if __name__ == '__main__':
    main()
