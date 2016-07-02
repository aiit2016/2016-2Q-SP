import sys

f = sys.stdin
d = {}
words_count = 0
while True:
    s = f.readline()
    if not s: break
    # print(s, file=sys.stdout)
    words = s.split()
    words_count += len(words)
    for w in words:
        if w in d:
            d[w] += 1
        else:
            d[w] = 1
        # print(w, d[w], file=sys.stdout)
print("Number of words:", words_count, file=sys.stdout)

sorted_keys = sorted(d.keys(), key=lambda x: d[x], reverse=True)
OUT_WORDS_COUNT = 20
print("Top {0:d} words:".format(OUT_WORDS_COUNT), file=sys.stdout)
i = 0
for k in sorted_keys:
    if i == OUT_WORDS_COUNT: break
    print(" {0}: -> {1}".format(k, d[k]), file=sys.stdout)
    i += 1
