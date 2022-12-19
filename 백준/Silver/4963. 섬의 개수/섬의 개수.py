import sys
sys.setrecursionlimit(10000)

def dfs(x, y):
    dx = [-1, 0, 1, -1, 1, -1, 0, 1]
    dy = [1, 1, 1, 0, 0, -1, -1, -1]
    
    arr[x][y] = 0
    for i in range(8):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if 0 <= nx < h and 0 <= ny < w and arr[nx][ny] == 1:
            dfs(nx, ny)

while 1:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    
    arr = [list(map(int, input().split())) for _ in range(h)]
    cnt = 0
    for i in range(h):
        for j in range(w):
            if arr[i][j] == 1:
                dfs(i, j)
                cnt += 1

    print(cnt)