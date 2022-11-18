T = int(input())
for test in range(1, T+1):
    L, U, X = map(int, input().split())
    
    if X < L:
        print("#{} {}".format(test, L - X))
    elif X > U:
        print("#{} {}".format(test, -1))
    else:
        print("#{} {}".format(test, 0))