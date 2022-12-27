import math
t = int(input())
for _ in range(t):
    temp = list(map(int, input().split()))
    n = temp[0]
    num = temp[1:]

    sum = 0
    for i in range(len(num)):
        for j in range(i+1, len(num)):
            sum += math.gcd(num[i], num[j])

    print(sum)