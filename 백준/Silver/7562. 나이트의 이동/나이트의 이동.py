from collections import deque
import sys
input = sys.stdin.readline
sys.setrecursionlimit(1000000)

dx = [-1, 1, 2, 2, 1, -1, -2, -2]
dy = [2, 2, 1, -1, -2, -2, -1, 1]
def bfs():
    q = deque()
    q.append((startX, startY))
    while q:
        x, y = q.popleft()
        if x == endX and y == endY:
            return graph[x][y]

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < l and 0 <= ny < l and graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                q.append((nx,ny))
                
T = int(input())
for _ in range(T):
    l = int(input())
    startX, startY = map(int, input().split())
    endX, endY = map(int, input().split())
    graph = [[0]*l for _ in range(l)]
    print(bfs())
