import os
import re
from collections import defaultdict

EXCLUDE_DIRS = {'.git', '.idea', '.vscode', '__pycache__'}

def count_files_per_folder(base_path='.'):
    folder_counts = defaultdict(int)
    for dirpath, dirnames, filenames in os.walk(base_path):
        dirnames[:] = [d for d in dirnames if d not in EXCLUDE_DIRS]
        folder_counts[dirpath] += len(filenames)
    return folder_counts

def extract_number(name):
    match = re.search(r'(\d+)$', name)
    return int(match.group(1)) if match else float('inf')

def print_tree(folder_counts, base_path='.', prefix="", is_last=True, skip_root=False, level=0):
    """Print folder hierarchy in a git/maven tree-like style with blank lines between top-level siblings only."""
    base_name = os.path.basename(base_path) or base_path
    if not skip_root:
        connector = "└── " if is_last else "├── "
        print(f"{prefix}{connector}{base_name} ({folder_counts[base_path]} files)")

    entries = []
    for entry in os.listdir(base_path):
        full_path = os.path.join(base_path, entry)
        if os.path.isdir(full_path) and entry not in EXCLUDE_DIRS:
            entries.append((entry, full_path))

    entries.sort(key=lambda x: extract_number(x[0]))

    new_prefix = prefix + ("    " if is_last else "│   ")
    for i, (name, path) in enumerate(entries):
        last = (i == len(entries) - 1)
        print_tree(folder_counts, path, new_prefix, last, skip_root=False, level=level+1)
        # insert blank line ONLY between top-level siblings
        if level == 0 and not last:
            print()

def main():
    choice = input("Do you want full hierarchy (y/n)? ").strip().lower()
    base_path = '.'

    if choice == 'y' or choice == 'Y':
        folder_counts = count_files_per_folder(base_path)
        print_tree(folder_counts, base_path, "", True, skip_root=True, level=0)
    else:
        # old style: just top-level folders
        counts = defaultdict(int)
        root_name = os.path.basename(os.path.abspath(base_path))
        for dirpath, dirnames, filenames in os.walk(base_path):
            dirnames[:] = [d for d in dirnames if d not in EXCLUDE_DIRS]
            rel_path = os.path.relpath(dirpath, base_path)
            parts = rel_path.split(os.sep) if rel_path != '.' else []
            top_folder = parts[0] if parts else root_name
            counts[top_folder] += len(filenames)

        print(f"{'Folder':<25} | {'File Count':>10}")
        print("-" * 40)
        total = 0
        for folder, count in sorted(counts.items(), key=lambda x: extract_number(x[0])):
            print(f"{folder:<25} | {count:>10}")
            total += count
        print("-" * 40)
        print(f"{'Total':<25} | {total:>10}")

if __name__ == '__main__':
    main()