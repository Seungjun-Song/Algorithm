from collections import deque
from sys import stdin
input = stdin.readline

N = int(input())
q = deque(enumerate(map(int, input().split())))
answer = []

while q:
    idx, paper = q.popleft()
    answer.append(idx+1)

    if paper > 0:
        q.rotate(-(paper-1))
    else:
        q.rotate(-paper)

print(*answer)