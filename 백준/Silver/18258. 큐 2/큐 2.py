from sys import stdin
from collections import deque
N = int(stdin.readline())
Q = deque([])
for _ in range(N):
    command = stdin.readline().split()
    
    if command[0] == "push":
        Q.append(command[1])
    elif command[0] == "pop":
        if not Q:
            print(-1)
        else:
            print(Q.popleft())
    elif command[0] == "size":
        print(len(Q))
    elif command[0] == "empty":
        if not Q:
            print(1)
        else:
            print(0)
    elif command[0] == "front":
        if not Q:
            print(-1)
        else:
            print(Q[0])
    elif command[0] == "back":
        if not Q:
            print(-1)
        else:
            print(Q[-1])