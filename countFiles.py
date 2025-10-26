import os
import re
from collections import defaultdict

# Folders to ignore
EXCLUDE_DIRS = {'.git', '.idea', '.vscode', '__pycache__'}

# Only count these file types
VALID_EXTENSIONS = {'.java', '.py'}


def count_files_per_folder(base_path='.'):
    """Return a dict mapping absolute folder path -> number of valid files directly in that folder."""
    folder_counts = defaultdict(int)
    base_abs = os.path.abspath(base_path)

    for dirpath, dirnames, filenames in os.walk(base_abs):
        # Skip unwanted directories
        dirnames[:] = [d for d in dirnames if d not in EXCLUDE_DIRS]
        folder_counts[dirpath] += sum(
            1 for f in filenames if os.path.splitext(f)[1] in VALID_EXTENSIONS
        )

    # Ensure base folder appears even if empty
    if base_abs not in folder_counts:
        folder_counts[base_abs] = 0

    return folder_counts


def compute_cumulative_counts(folder_counts):
    """
    Given folder_counts mapping (direct counts),
    compute cumulative counts: each folder's count =
    its direct files + sum of all descendant counts.
    """
    cumulative = dict(folder_counts)
    dirs_sorted = sorted(folder_counts.keys(), key=lambda p: p.count(os.sep), reverse=True)

    for d in dirs_sorted:
        parent = os.path.dirname(d)
        if parent in cumulative and parent != d:
            cumulative[parent] += cumulative[d]

    return cumulative


def extract_number(name):
    """Extract trailing number from folder name for sorted order."""
    match = re.search(r'(\d+)$', name)
    return int(match.group(1)) if match else float('inf')


def print_tree(folder_counts, cumulative_counts, base_path='.', prefix="", is_last=True, skip_root=False, level=0):
    """Recursively print folder hierarchy showing cumulative file counts."""
    base_abs = os.path.abspath(base_path)
    base_name = os.path.basename(base_abs) or base_abs

    if not skip_root:
        connector = "└── " if is_last else "├── "
        print(f"{prefix}{connector}{base_name} ({cumulative_counts.get(base_abs, 0)} files)")

    entries = []
    for entry in sorted(os.listdir(base_abs), key=lambda x: extract_number(x)):
        full_path = os.path.join(base_abs, entry)
        if os.path.isdir(full_path) and entry not in EXCLUDE_DIRS:
            entries.append((entry, full_path))

    new_prefix = prefix + ("    " if is_last else "│   ")
    for i, (name, path) in enumerate(entries):
        last = (i == len(entries) - 1)
        print_tree(folder_counts, cumulative_counts, path, new_prefix, last, skip_root=False, level=level + 1)

        # Add spacing only between top-level siblings for readability
        if level == 0 and not last:
            print()


def main():
    choice = input("Do you want full hierarchy (y/n)? ").strip().lower()
    base_path = '.'

    folder_counts = count_files_per_folder(base_path)
    cumulative_counts = compute_cumulative_counts(folder_counts)
    base_abs = os.path.abspath(base_path)
    root_name = os.path.basename(base_abs)

    if choice == 'y':
        # Show full folder hierarchy, skipping the root name display
        print_tree(folder_counts, cumulative_counts, base_path, "", True, skip_root=True, level=0)
    else:
        # Print summary table for top-level folders
        print(f"Root: {root_name}")
        print(f"{'Folder':<40} | {'File Count':>10}")
        print("-" * 55)

        total = 0
        # Only include immediate subfolders (not the root itself)
        top_level_dirs = [
            d for d in os.listdir(base_abs)
            if os.path.isdir(os.path.join(base_abs, d)) and d not in EXCLUDE_DIRS
        ]

        for folder in sorted(top_level_dirs, key=extract_number):
            folder_abs = os.path.join(base_abs, folder)
            cnt = cumulative_counts.get(os.path.abspath(folder_abs), 0)
            print(f"{folder:<40} | {cnt:>10}")
            total += cnt

        print("-" * 55)
        print(f"{'Total':<40} | {total:>10}")


if __name__ == '__main__':
    main()
