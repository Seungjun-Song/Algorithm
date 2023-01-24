N = int(input())
num = [int(input()) for _ in range(N)]
num.sort(reverse=True)
for i in num:
    print(i)