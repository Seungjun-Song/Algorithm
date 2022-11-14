T = int(input())
for test in range(1, T+1):
    ss = input()
    check = True
    
    for i in range(len(ss) // 2):
        if ss[i] != ss[-1-i]:
            check = False
            break
    
    if check:
        print("#%d 1" % test)
    else:
        print("#%d 0" % test)