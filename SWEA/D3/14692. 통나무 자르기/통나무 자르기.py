T = int(input())
for test in range(1, T+1):
    N = int(input())
    
    if N % 2 == 0:
        print("#%d Alice" % (test))
    else:
        print("#%d Bob" % (test))