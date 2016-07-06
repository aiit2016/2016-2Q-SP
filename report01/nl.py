import sys

argc = len(sys.argv)
if argc == 1:
    f = sys.stdin
elif argc == 2:
    try:
        f = open(sys.argv[1], "rU")
    except IOError:
        sys.exit("nl: %s: No such file or directory" % (sys.argv[1]))
else:
    sys.exit("usage: nl [file]")

# read data
line_number = 0
while True:
    s = f.readline()
    if not s: break
    if len(s.strip()) == 0:
        print(s, end='')
    else:
        line_number += 1
        print("{0} {1}".format(line_number, s), end='')
