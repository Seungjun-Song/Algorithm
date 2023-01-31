from sys import stdin
input = stdin.readline

def dfs(idx):
    global cnt
    visited[idx] = 1
    
    for i in country[idx]:
        if visited[i] == 0:
            cnt += 1
            dfs(i)

T = int(input())
for _ in range(T):
    N, M = map(int, input().split())
    country = [[] for _ in range(N+1)]
    visited = [0] * (N+1)
    visited[0] = 1
    cnt = 0
    for _ in range(M):
        a, b = map(int, input().split())
        country[a].append(b)
        country[b].append(a)
    
    dfs(1)
    print(cnt)