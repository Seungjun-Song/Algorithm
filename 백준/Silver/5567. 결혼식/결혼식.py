from collections import deque
def bfs(node):
    q = deque()
    q.append(node)
    visited[node] = 1
    while q:
        a = q.popleft()
        for i in range(1, n+1):
            if graph[a][i] == 1 and visited[i] == 0:
                visited[i] = visited[a] + 1
                q.append(i)

n = int(input())
m = int(input())
graph = [[0 for _ in range(n+1)] for _ in range(n+1)]
visited = [0 for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

bfs(1)
print(sum(1 for i in visited if 2 <= i <= 3))