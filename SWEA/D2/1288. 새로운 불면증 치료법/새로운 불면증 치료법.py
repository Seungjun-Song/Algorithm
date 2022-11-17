T = int(input())
for test in range(1, T+1):
    N = input()
    cnt = 0
    arr = [0] * 10
    
    while 0 in arr:
        cnt += 1
        temp = str(int(N) * cnt)
        for n in temp:
            arr[int(n)] = 1
        
    print("#%d %s" % (test, temp))