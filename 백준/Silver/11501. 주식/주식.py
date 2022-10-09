T = int(input())
for _ in range(T):
    N = int(input())
    stock = list(map(int, input().split()))
    stock.reverse()
    up = stock[0]
    sum = 0
    for i in range(1, N):
        if up < stock[i]:
            up = stock[i]
            continue
        sum += up - stock[i]
    print(sum)    