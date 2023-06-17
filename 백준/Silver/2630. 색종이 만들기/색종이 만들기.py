N = int(input())
arr = [list(input().split()) for _ in range(N)]
color = [0, 0]

def dfs(x, y, N):
    check = arr[x][y]
    for i in range(x, x+N):
        for j in range(y, y+N):
            if check != arr[i][j]:
                dfs(x, y, N//2)
                dfs(x, y+N//2, N//2)
                dfs(x+N//2, y, N//2)
                dfs(x+N//2, y+N//2, N//2)
                return
    
    if check == '0':
        color[0] += 1
    else:
        color[1] += 1
    
dfs(0, 0, N)
for i in color:
    print(i)