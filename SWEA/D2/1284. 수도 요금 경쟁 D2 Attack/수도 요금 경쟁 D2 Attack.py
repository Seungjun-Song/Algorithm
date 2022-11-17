T = int(input())
for test in range(1, T+1):
    P, Q, R, S, W = map(int, input().split())
    A = P * W
    if W < R:
        B = Q
    else:
        B = Q + S * (W - R)
        
    if A < B:
        print("#%d %d" % (test, A))
    else:
        print("#%d %d" % (test, B))