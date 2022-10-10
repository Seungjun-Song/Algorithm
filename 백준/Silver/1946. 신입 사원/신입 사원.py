from sys import stdin

T = int(input())
for _ in range(T):
    N = int(stdin.readline())
    score = [list(map(int, stdin.readline().split())) for _ in range(N)]
    score.sort()

    cnt = 1
    minValue = score[0][1]
    for i in range(1, N):
        if minValue > score[i][1]: # 등수가 높으면
            minValue = score[i][1]
            cnt += 1

    print(cnt)