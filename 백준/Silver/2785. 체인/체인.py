from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
ring = deque(sorted(list(map(int, input().split()))))

answer = 0
while answer < len(ring)-1:
    ring[0] -= 1
    answer += 1
    
    if ring[0] == 0:
        ring.popleft()   
    
print(answer)