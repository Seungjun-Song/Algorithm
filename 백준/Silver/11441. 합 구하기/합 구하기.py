from sys import stdin
input = stdin.readline

N = int(input())
num = list(map(int, input().split()))
for i in range(1, len(num)):
    num[i] += num[i-1]
M = int(input())
for _ in range(M):
    i, j = map(int, input().split())
    if i == 1:
        print(num[j-1])
    else:
        print(num[j-1] - num[i-2])