N = int(input())
length = list(map(int, input().split()))
price = list(map(int, input().split()))
answer = 0

min = price[0]
for i in range(N-1):
    if min > price[i]:
        min = price[i]
    answer += min * length[i]

print(answer)