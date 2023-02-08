import sys
input = sys.stdin.readline

n = int(input())
arr = sorted(list(map(int, input().split())))
x = int(input())

L, R = 0, n-1
cnt = 0
while L < R:
    y = arr[L]+arr[R]
    if y == x:
        R -= 1
        cnt += 1
    elif y > x:
        R -= 1
    elif y < x:
        L += 1
print(cnt)