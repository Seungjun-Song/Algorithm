T = int(input())
for test in range(1, T+1):
    N = int(input())
    sum = 0
    
    for i in range(1, N+1):
        if i%2 == 1:
            sum += i
        else:
            sum -= i
            
    print("#%d %d" % (test, sum))