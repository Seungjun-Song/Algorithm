def dfs(depth):
    if depth == N:
        print(*answer)
    
    for i in range(1, N+1):
        if i not in answer:
            answer.append(i)
            dfs(depth+1)
            answer.pop()

N = int(input())
answer = []
dfs(0)