def fb(n):
    return {0: "Fizz"}.get(n % 3, "") + {0: "Buzz"}.get(n % 5, "")

i = 1
while i <= 20:
    print(i, fb(i))
    i += 1
