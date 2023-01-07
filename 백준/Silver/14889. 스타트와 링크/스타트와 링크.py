def bfs(depth, idx):
    global answer
    if depth == N//2:
        t1, t2 = 0, 0
        for i in range(N):
            for j in range(N):
                if check[i] and check[j]:
                    t1 += stat[i][j]
                elif not check[i] and not check[j]:
                    t2 += stat[i][j]
        answer = min(answer, abs(t1-t2))
        return

    for i in range(idx, N):
        if not check[i]:
            check[i] = 1
            bfs(depth+1, i+1)
            check[i] = 0
    

N = int(input())
stat = [list(map(int, input().split())) for _ in range(N)]
check = [0] * N
answer = 1000000

bfs(0, 0)
print(answer)