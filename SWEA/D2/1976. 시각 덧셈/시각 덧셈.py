T = int(input())
for test in range(1, T+1):
    h1, m1, h2, m2 = map(int, input().split())
    
    m = m1 + m2
    h = h1 + h2
    
    if m > 59:
        m -= 60
        h += 1
    
    if h > 11:
        h -= 12
    
    print("#{} {} {}".format(test, h, m))