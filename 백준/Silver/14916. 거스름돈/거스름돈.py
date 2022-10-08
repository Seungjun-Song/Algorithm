n = int(input())
coin = [-1, -1, 1, -1, 2, 1, 3, 2, 4, 3]

for i in range(10, n+1):
    coin.append(coin[i-5]+1)
print(coin[n])