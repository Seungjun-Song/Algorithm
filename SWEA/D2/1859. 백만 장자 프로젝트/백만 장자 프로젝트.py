T = int(input())
for test in range(1, T+1):
    N = int(input())
    price = list(map(int, (input().split())))
    price.reverse()

    profit = 0
    maxstock = price[0]
    for i in range(len(price)):
        if price[i] < maxstock:
            profit += maxstock - price[i]
        else:
            maxstock = price[i]
            
    print('#%d %d' % (test, profit))