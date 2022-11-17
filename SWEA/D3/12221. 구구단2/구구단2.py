T = int(input())
for test in range(1, T+1):
    A, B = map(int, input().split())

    if A > 9 or B > 9:
        print("#%d %d" % (test, -1))
    else:
        print("#%d %d" % (test, A*B))