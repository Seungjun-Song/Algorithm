T = int(input())
for test in range(1, T+1):
    ss = input()

    for i in range(1, len(ss)):
        if ss[0:i] == ss[i:2*i]:
            print("#%d %d" % (test, i))
            break