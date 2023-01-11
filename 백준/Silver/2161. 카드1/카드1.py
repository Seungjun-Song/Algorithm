from collections import deque
N = int(input())
q = deque(i for i in range(1, N+1))
answer = []

while len(q) > 1:
    answer.append(q.popleft())
    q.append(q.popleft())

answer.append(q[0])
print(*answer)