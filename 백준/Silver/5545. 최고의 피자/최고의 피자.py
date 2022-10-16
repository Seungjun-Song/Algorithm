N = int(input())
A, B = map(int, input().split())
C = int(input())
D = [int(input()) for _ in range(N)]

D.sort(reverse=True)
answer = C / A

for i in range(1, len(D)+1):
    calorie = C + sum(D[0:i])
    price = A + (B*i)

    if calorie / price > answer:
        answer = calorie / price
    else:
        break

print(int(answer))