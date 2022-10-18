num = [int(input()) for _ in range(9)]

for i in range(8):
    for j in range(i+1, 9):
        if sum(num) - num[i] - num[j] == 100:
            x, y = i, j
            break

num.pop(x)
num.pop(y-1)
num.sort()
for n in num:
    print(n)