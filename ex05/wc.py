import sys

argc = len(sys.argv)
if argc == 1:
    f = sys.stdin
elif argc == 2:
    try:
        f = open(sys.argv[1], "rU")
    except IOError:
        sys.exit("wc: %s: No such file or directory" % (sys.argv[1]))
else:
    sys.exit("usage: wc [file]")

# read data
data = f.read()
data = data.lower()
data = data.replace(',', ' ')
data = data.replace('.', ' ')
data = data.replace('-­­', ' ')
data = data.replace('_', ' ')
data = data.replace(';', ' ')
data = data.replace(':', ' ')
data = data.replace('"', ' ')
data = data.replace("'", ' ')
data = data.replace('?', ' ')
data = data.replace('!', ' ')
data = data.replace('(', ' ')
data = data.replace(')', ' ')
data = data.replace('/', ' ')
data = data.replace('=', ' ')
data = data.replace('#', ' ')
words = data.split()
print("Number of words:", len(words), file=sys.stdout)

# counting
sort_words = {}
for word in words:
    sort_words[word] = sort_words.get(word, 0) + 1

# sort by count
d = [(v, k) for k, v in sort_words.items()]
d.sort()
d.reverse()

OUT_WORDS_COUNT = 20
print("Top {0:d} words:".format(OUT_WORDS_COUNT), file=sys.stdout)
for count, word in d[:OUT_WORDS_COUNT]:
    print(" {0}: -> {1}".format(word, count), file=sys.stdout)
