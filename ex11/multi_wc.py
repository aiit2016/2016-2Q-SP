# -*- coding: utf-8 -*-

import sys
import subprocess

url_map = {}

for index, url in enumerate(sys.argv):
    if index == 0:
        continue
    url_map[url] = subprocess.getoutput('curl -A "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.63 Safari/537.36" -s %s | wc -w' % url).strip()

count = 0
v_list = []
for k, v in url_map.items():
    count += int(v)
    v_list.append(v)

print("Total: %d = %s" % (count, " + ".join(v_list)))
for k, v in url_map.items():
    print("%d\t%s" % (int(v), k))
