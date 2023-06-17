from collections import deque
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
N, M = map(int, input().split())
campus = [input() for _ in range(N)]
visited = [[False] * M for _ in range(N)]
q = deque()

cnt = 0
def bfs(x, y):
    global cnt
    q.append((x, y))
    
    while q:
        x, y = q.popleft()
        if campus[x][y] == 'P':
            cnt += 1
            
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and campus[nx][ny] != 'X':
                visited[nx][ny] = True
                q.append((nx, ny))
        
for i in range(N):
    for j in range(M):
        if campus[i][j] == 'I':
            bfs(i, j)
            break

print(cnt if cnt != 0 else 'TT')