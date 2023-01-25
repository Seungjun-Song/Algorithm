from collections import deque

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def dfs(left, right):
    if left > graph[0][0] or right < graph[0][0]:
        return False
        
    q = deque()
    q.append([0, 0])
    visited = [[False] * n for _ in range(n)]
    visited[0][0] = True
    while q:
        x, y = q.popleft()

        if x == y == n-1:
            return True

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and left <= graph[nx][ny] <= right:
                q.append([nx, ny])
                visited[nx][ny] = True

    return False

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
left, right, limit = 0, 0, max(map(max, graph))
answer = 1e9

while left <= limit and right <= limit:
    if dfs(left, right):
        answer = min(answer, right-left)
        left += 1
    else:
        right += 1

print(answer)