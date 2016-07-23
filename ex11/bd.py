# -*- coding: utf-8 -*-

from datetime import datetime
import sys

birthday = datetime.strptime(sys.argv[1], "%Y/%M/%d")
now = datetime.now()
how_old = int((now - birthday).days / 365.25)
if (now.month - birthday.month) > 0 :
    month = now.month - birthday.month
else:
    month = (now.month + 12) - birthday.month

next_birthday = birthday.replace(year=now.year)
if (next_birthday - now).days < 0:
    next_birthday = next_birthday.replace(year=next_birthday.year + 1)

print("You are %d (and %d months) years old" % (how_old, month))
print("Your next birthday is %d days later" % (next_birthday - now).days)
