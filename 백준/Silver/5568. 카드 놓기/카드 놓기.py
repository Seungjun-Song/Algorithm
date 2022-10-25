def dfs(depth):
    if depth == k:
        answer.add(''.join(temp))
        return
    
    for i in range(n):
        if not visited[i]:
            temp.append(card[i])
            visited[i] = 1
            dfs(depth+1)
            visited[i] = 0
            temp.pop()

n = int(input())
k = int(input())
card = [input() for _ in range(n)]
temp = []
answer = set()
visited = [0 for _ in range(n)]
dfs(0)
print(len(answer))