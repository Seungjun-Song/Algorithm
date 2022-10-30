from collections import deque

N, K = map(int, input().split())

def bfs():
    queue = deque()
    queue.append(N)
    while queue:
        x = queue.popleft()
        if x == K:
            print(arr[x])
            break
        for nx in (x-1, x+1, x*2):
            if 0<= nx <= max and not arr[nx]:
                arr[nx] = arr[x] + 1
                queue.append(nx)        
            
max = 10 ** 5
arr = [0] * (max + 1)

bfs()