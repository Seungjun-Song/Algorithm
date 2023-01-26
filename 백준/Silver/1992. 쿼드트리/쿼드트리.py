def dfs(x, y, n):
    check = graph[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if check != graph[i][j]:
                print('(', end="")
                dfs(x, y, n//2)
                dfs(x, y+n//2, n//2)
                dfs(x+n//2, y, n//2)
                dfs(x+n//2, y+n//2, n//2)
                print(')', end="")
                return
      
    print(1, end="") if check == '1' else print(0, end="")

N = int(input())
graph = [input() for _ in range(N)]
answer = []
dfs(0, 0, N)