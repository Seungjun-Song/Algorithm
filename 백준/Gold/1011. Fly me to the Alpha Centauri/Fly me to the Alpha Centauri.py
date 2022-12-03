import math
T = int(input())
for _ in range(T):
    x, y = map(int, input().split())
    distance = y-x
    cnt = 0

    num_square = math.floor(math.sqrt(distance))
    num = num_square ** 2

    if distance == num:
        cnt = 2 * num_square - 1
    elif distance <= num + num_square:
        cnt = 2 * num_square
    else:
        cnt = 2 * num_square + 1

    if distance < 4:
        cnt = distance
        
    print(cnt)