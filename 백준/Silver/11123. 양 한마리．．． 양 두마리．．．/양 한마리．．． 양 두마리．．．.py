import sys
sys.setrecursionlimit(10000000)
def dfs(x, y):
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]

    for i in range(4):
        tx = x + dx[i]
        ty = y + dy[i]

        if 0 <= tx < H and 0 <= ty < W and arr[tx][ty] == '#':
            arr[tx][ty] = '.'
            dfs(tx, ty)

T = int(input())
for _ in range(T):
    H, W = map(int, input().split())
    arr = [list(input()) for _ in range(H)]
    cnt = 0

    for i in range(H):
        for j in range(W):
            if arr[i][j] == '#':
                cnt += 1
                arr[i][j] = '.'
                dfs(i, j)

    print(cnt)