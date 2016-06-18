def first_last(s1):
    # [out of bound error] s2 = s1[0] + s1[1] + s1[4] + s1[5]
    # [out of bound error] s2 = s1[0] + s1[1] + s1[-2] + s1[-1]
    # [false result] s2 = s1[0:2] + s1[-2:-1]
    s2 = s1[0:2] + s1[-2:]
    # [out of bound error] s2 = s1[:2] + s1[-2]
    return s2

print(first_last("spring"))
print(first_last("hello"))
print(first_last("a"))
print(first_last("abc"))
