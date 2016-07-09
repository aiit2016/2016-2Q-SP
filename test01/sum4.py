def sum4(data):
    total = 0
    skip_next = False
    for item in data:
        if not skip_next:
            total += item
        if item == 4:
            skip_next = True
        else:
            skip_next = False
    return total

print(sum4([1, 2]))
print(sum4([3, 4]))
print(sum4([4, 5, 6]))
print(sum4([4, 9, 4, 9, 4, 9]))
print(sum4([]))