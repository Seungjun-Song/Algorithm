T = int(input())
for test in range(1, T+1):
    N = int(input())

    money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
    answer = [0] * 8

    for i in range(8):
        if N // money[i] != 0:
            answer[i] = N // money[i]
            N %= money[i]

    print("#{}".format(test))
    print(*answer)