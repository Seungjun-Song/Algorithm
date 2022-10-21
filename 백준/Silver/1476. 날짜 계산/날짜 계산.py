E, S, M = map(int, input().split())
a, b, c = 1, 1, 1

year = 1
while 1:
    if E == a and S == b and M == c:
        break
    
    a += 1
    b += 1
    c += 1
    
    if a > 15:
        a = 1
    if b > 28:
        b = 1
    if c > 19:
        c = 1

    year += 1

print(year)