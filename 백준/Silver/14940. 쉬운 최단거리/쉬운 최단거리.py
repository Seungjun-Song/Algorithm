from collections import deque
n, m = map(int, input().split())
map = [list(map(int, input().split())) for _ in range(n)]
answer = [[0] * m for _ in range(n)]
q = deque()
for i in range(n):
    for j in range(m):
        if map[i][j] == 2:
            q.append((i, j))
            break
            
visited = [[False] * m for _ in range(n)]
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
while q:
    x, y = q.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and map[nx][ny] == 1:
            visited[nx][ny] = True
            answer[nx][ny] = answer[x][y]+1
            q.append((nx, ny))

for i in range(n):
    for j in range(m):
        if map[i][j] == 1 and answer[i][j] == 0:
            answer[i][j] = -1

for ans in answer:
    for a in ans:
        print(a, end=" ")
    print()