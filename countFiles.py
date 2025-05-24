import os
import re
from collections import defaultdict

EXCLUDE_DIRS = {'.git', '.idea', '.vscode', '__pycache__'}

def count_files_per_top_folder(base_path='.'):
    file_counts = defaultdict(int)
    root_name = os.path.basename(os.path.abspath(base_path))

    for dirpath, dirnames, filenames in os.walk(base_path):
        dirnames[:] = [d for d in dirnames if d not in EXCLUDE_DIRS]

        rel_path = os.path.relpath(dirpath, base_path)
        parts = rel_path.split(os.sep) if rel_path != '.' else []

        top_folder = parts[0] if parts else root_name
        file_counts[top_folder] += len(filenames)

    return file_counts

def extract_number(name):
    # Match the last integer in the folder name (e.g., "parent 2" => 2)
    match = re.search(r'(\d+)$', name)
    return int(match.group(1)) if match else float('inf')  # folders without numbers go last

def main():
    counts = count_files_per_top_folder('.')

    # Sort by extracted integer from folder name
    sorted_counts = sorted(counts.items(), key=lambda x: extract_number(x[0]))

    print(f"{'Folder':<25} | {'File Count':>10}")
    print("-" * 40)
    total = 0
    for folder, count in sorted_counts:
        print(f"{folder:<25} | {count:>10}")
        total += count
    print("-" * 40)
    print(f"{'Total':<25} | {total:>10}")

if __name__ == '__main__':
    main()
