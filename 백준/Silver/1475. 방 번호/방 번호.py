N = input()
num = [0] * 10

for n in N:
    n = int(n)
    if n == 6 or n == 9:
        if num[6] < num[9]:
            num[6] += 1
        else:
            num[9] += 1
    else:
        num[n] += 1

print(max(num))