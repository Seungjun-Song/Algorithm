import sys
sys.setrecursionlimit(10000)

def dfs(x, y):    
    if arr[x][y] == '-':
        arr[x][y] = 0
        for i in [1, -1]:
            ny = y + i
            if 0 <= ny < M and arr[x][ny] == '-':
                dfs(x, ny)    
    
    if arr[x][y] == '|':
        arr[x][y] = 0
        for i in [1, -1]:
            nx = x + i
            if 0 <= nx < N and arr[nx][y] == '|':
                dfs(nx, y)

N, M = map(int, input().split())
arr = [list(input()) for _ in range(N)]
cnt = 0
for i in range(N):
    for j in range(M):
        if arr[i][j] == '-' or arr[i][j] == '|':
            dfs(i, j)
            cnt += 1
print(cnt)