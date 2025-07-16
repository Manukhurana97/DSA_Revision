import subprocess
import sys
from datetime import datetime

def run_command(cmd):
    result = subprocess.run(cmd, shell=True)
    if result.returncode != 0:
        print(f"❌ Error running command: {cmd}")
        sys.exit(result.returncode)

def main():
    # Get commit message from CLI or use today's date
    commit_msg = ""
    if len(sys.argv) > 1:
        commit_msg = sys.argv[1] 
    else:
        commit_msg = input("Enter commit message: ").strip()
        if not commit_msg:
            commit_msg = datetime.now().strftime("%Y-%m-%d")

    print("📥 Pulling latest changes...")
    run_command("git pull")

    print("📦 Adding all changes...")
    run_command("git add .")

    print(f"📝 Committing with message: '{commit_msg}'")
    run_command(f'git commit -m "{commit_msg}"')

    print("📤 Pushing to remote...")
    run_command("git push")

    print("✅ Done.")

if __name__ == "__main__":
    main()
