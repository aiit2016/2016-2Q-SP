import sys
import subprocess

while True:
    sys.stdout.write("mysh>")
    sys.stdout.flush()
    command = sys.stdin.readline()
    if not command or len(command.strip()) == 0:
        continue
    command = command.strip()
    if command == "exit":
        break
    else:
        p = subprocess.Popen(command, shell=True, stderr=subprocess.STDOUT)
        (output, err) = p.communicate()
        p.wait()
