import math

T = int(input())
for test in range(1, T+1):
    N, D = map(int, input().split())

    answer = math.ceil(N / (1 + D * 2))

    print("#%d %d" % (test, answer))