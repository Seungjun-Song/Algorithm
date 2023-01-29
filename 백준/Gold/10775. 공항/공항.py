from sys import stdin
input = stdin.readline

def find(x):
    if x == visited[x]:
        return x
    else:
        visited[x] = find(visited[x])
        return visited[x]

def union(x, y):
    x = find(x)
    y = find(y)
    visited[x] = y
    return

G = int(input())
P = int(input())
visited = [i for i in range(G+1)]

cnt = 0
for _ in range(P):
    gate = int(input())
    parent = find(gate)
    if parent == 0:
        break
    union(parent, parent-1)
    cnt += 1
print(cnt)