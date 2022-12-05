from collections import deque
N, M = map(int, input().split())
arr = list(map(int, input().split()))
Q = deque(i for i in range(1, N+1))

cnt = 0
for i in arr:
    while True:
        if Q[0] == i:
            Q.popleft()
            break
        else:
            if Q.index(i) < len(Q)/2:
                while Q[0] != i:
                    Q.append(Q.popleft())
                    cnt += 1
            else:
                while Q[0] != i:
                    Q.appendleft(Q.pop())
                    cnt += 1
                    
print(cnt)
        