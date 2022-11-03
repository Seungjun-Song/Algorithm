N = int(input())
M = int(input())

def DFS(n):
    visited[n] = 1
    for i in graph[n]:
        if not visited[i]:
            DFS(i)

graph = [[] for _ in range(N+1)]
for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [0] * (N+1)
DFS(1)
print(visited.count(1) - 1)