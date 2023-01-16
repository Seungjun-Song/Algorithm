N, M = map(int, input().split())
ss = list(input() for _ in range(N))

cnt = 0
for i in range(M):
    s = input()
    for j in ss:
        if s == j[:len(s)]:
            cnt += 1
            break

print(cnt)