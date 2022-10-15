T = int(input())
pibo = [0, 1]

for i in range(2, 50):
    pibo.append(pibo[i-1] + pibo[i-2])

for _ in range(T):
    num = int(input())

    answer = []
    while num != 0:
        i = 0
        while num >= pibo[i]:
            i += 1
        num -= pibo[i-1]
        answer.append(pibo[i-1])

    answer.sort()
    for a in answer:
        print(a, end=" ")