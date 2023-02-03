import sys
input = sys.stdin.readline
sys.setrecursionlimit(1000000)

def dfs(idx, node):
    if idx != 1:
        answer.append([idx, node])
        
    visited[idx] = True
    for i in graph[idx]:
        if not visited[i]:
            dfs(i, idx)

N = int(input())
graph = [[] for _ in range(N+1)]
visited = [False] * (N+1)
answer = []
for _ in range(N-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

dfs(1, 1)
for a in sorted(answer):
    print(a[1])