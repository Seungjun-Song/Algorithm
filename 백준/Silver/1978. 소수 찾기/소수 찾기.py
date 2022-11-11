N = int(input())
num = list(map(int, input().split()))
answer = 0

for i in num:
    Noanswer = 0
    if i > 1:
        for j in range(2, i):
            if i % j == 0:
                Noanswer += 1
        if Noanswer == 0:
            answer += 1

print(answer)