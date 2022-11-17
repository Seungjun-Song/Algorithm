T = int(input())
for test in range(1, T+1):
    S = input()
    if S.count('x') > 7:
        print("#%d NO" % test)
    else:
        print("#%d YES" % test)