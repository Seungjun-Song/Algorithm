T = int(input())
for test in range(1, T+1):
    N = input()
    numbers = [0] * 10
    for i in range(len(N)):
        numbers[int(N[i])] += 1

    check = False
    for i in range(2, 10):
        compare = [0] * 10
        mul = str(int(N) * i)
        for j in range(len(mul)):
            compare[int(mul[j])] += 1
        if numbers == compare:
            check = True
            break
            
    if check:
        print("#%d possible" % (test))
    else:
        print("#%d impossible" % (test))