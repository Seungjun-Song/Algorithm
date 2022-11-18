T = int(input())
for test in range(1, T+1):
    N = int(input())
    arr = list(map(int, input().split()))
    avg = sum(arr) / N

    cnt = 0
    for a in arr:
        if a <= avg:
            cnt += 1
    
    print("#{} {}".format(test, cnt))