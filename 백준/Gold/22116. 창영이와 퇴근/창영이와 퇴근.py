import heapq

def dfs(r, c):
    slope[r][c] = 0
    heap = []
    heapq.heappush(heap, [0, r, c])
    while heap:
        dist, r, c = heapq.heappop(heap)
        
        if slope[r][c] < dist:
            continue

        if r == c == N-1:
            return

        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]
        for i in range(4):
            nx = r + dx[i]
            ny = c + dy[i]

            if 0 <= nx < N and 0 <= ny < N:
                if slope[nx][ny] > max(dist, abs(graph[nx][ny] - graph[r][c])):
                    slope[nx][ny] = max(dist, abs(graph[nx][ny] - graph[r][c]))
                    heapq.heappush(heap, [slope[nx][ny], nx, ny])

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
slope = list([1e9] * N for _ in range(N))

dfs(0, 0)
print(slope[-1][-1])