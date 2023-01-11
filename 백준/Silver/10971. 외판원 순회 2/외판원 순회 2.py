def bfs(start, end, cost):
    if sum(visited) == N-1:
        if graph[start][end] != 0:
            cost += graph[start][end]
            answer.append(cost)
        return

    for i in range(N):
        if graph[start][i] != 0 and visited[i] == 0 and i != end:
            cost += graph[start][i]
            visited[i] = 1
            bfs(i, end, cost)
            visited[i] = 0
            cost -= graph[start][i]

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
visited = [0] * N
answer = []
for i in range(N):
    bfs(i, i, 0)
    visited = [0] * N

print(min(answer))