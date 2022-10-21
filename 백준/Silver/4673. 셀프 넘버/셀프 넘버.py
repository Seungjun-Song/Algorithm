num = [0] * 10011

for i in range(1, 9978):
    value = i
    for s in str(i):
        value += int(s)
    num[value] = 1

for i in range(1, 10001):
    if num[i] == 0:
        print(i)