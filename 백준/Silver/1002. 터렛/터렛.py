import math

T = int(input())
for _ in range(T):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())

    distance = math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2)

    if distance == 0 and r1 == r2:
        print(-1)
    elif distance > abs(r2 - r1) and distance < r2 + r1:
        print(2)
    elif distance == abs(r2 - r1) or distance == r2 + r1:
        print(1)
    else:
        print(0)