def fb(n):
    ret = ""
    if n % 3 == 0:
        ret += "Fizz"
    if n % 5 == 0:
        ret += "Buzz"
    return ret

i = 1
while i <= 20:
    print(i, fb(i))
    i += 1
