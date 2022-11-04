from sys import stdin
N = int(stdin.readline())
info = []

for i in range(N):
    info.append(stdin.readline().split())
    info[i][0] = int(info[i][0])

info.sort(key = lambda a : (a[0]))

for i in info:
    print(i[0],i[1])