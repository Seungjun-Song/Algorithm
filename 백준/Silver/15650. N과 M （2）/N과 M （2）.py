def bfs(idx):
    if len(arr) == M:
        print(" ".join(map(str, arr)))
        
    for i in range(idx, N+1):
        if i not in arr:
            arr.append(i)
            bfs(i+1)
            arr.pop()

N, M = map(int, input().split())
arr = []
bfs(1)