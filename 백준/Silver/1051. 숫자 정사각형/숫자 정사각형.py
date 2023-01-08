def dfs(x, y, plus):
    if 0 <= x+plus < N and 0 <= y+plus < M:
        a = int(graph[x][y])
        b = int(graph[x][y+plus])
        c = int(graph[x+plus][y])
        d = int(graph[x+plus][y+plus])
        if a == b == c == d:
            answer.append((plus+1)**2)
        dfs(x, y, plus+1)

N, M = map(int, input().split())
graph = [list(input()) for _ in range(N)]
answer = []

for i in range(N-1):
    for j in range(M):
        dfs(i, j, 1)

if answer:
    print(max(answer))
else:
    print(1)