from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(i, j):
    queue = deque()
    queue.append((i, j))
    arr[i][j] = 0

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M and arr[nx][ny] == 1:
                arr[nx][ny] = 0
                queue.append((nx, ny))

T = int(input())
for i in range(T):
    M, N, K = map(int, input().split())
    cnt = 0
    arr = [[0 for i in range(M)] for i in range(N)]
    for i in range(K):

        a, b = map(int, input().split())
        arr[b][a] = 1

    for i in range(N):
        for j in range(M):
            if arr[i][j] == 1:
                bfs(i, j)
                cnt += 1
                
    print(cnt)