N, M = map(int, input().split())
ss = [input() for _ in range(N)]

cnt = 0
for _ in range(M):
    s = input()
    if s in ss:
        cnt += 1
print(cnt)