# 1011번

import math

T = int(input())

for _ in range(T):
    x, y = map(int, input().split())
    distance = y - x
    count = 0

    num = math.floor(math.sqrt(distance))   # n제곱 <= 거리 < (n+1)제곱일때 n제곱
    num_square = num ** 2   # n제곱의 제곱

    if distance > num_square + num:
        count = 2 * num + 1
    elif distance > num_square and distance <= num_square + num:
        count = 2 * num
    elif distance == num_square:
        count = 2 * num - 1

    if distance < 4:
        count = distance

    print(count)