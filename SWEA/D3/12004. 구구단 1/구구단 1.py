T = int(input())
for test in range(1, T+1):
    N = int(input())
    arr = []
    for i in range(1, 10):
        for j in range(1, 10):
            arr.append(i*j)
    
    if N in arr:
        print("#%d Yes" % (test))
    else:
        print("#%d No" % (test))