T = int(input())
for test in range(1, T+1):
    grassland = input()
    if grassland[0] == "(":
        cnt = 1
    else:
        cnt = 0
    
    for i in range(1, len(grassland)):
        if grassland[i] == "(":
            cnt += 1
        elif grassland[i] == ")":
            if grassland[i-1] == "(":
                continue
            cnt += 1
            
    print("#%d %d" % (test, cnt))