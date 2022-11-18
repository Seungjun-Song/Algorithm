T = int(input())
for test in range(1, T+1):
    N = list(input())

    flag = 0
    cnt = 0
    for i in range(len(N)):
        if flag == 0 and N[i] == '1':
            flag = 1
            cnt += 1
        elif flag == 1 and N[i] == '0':
            flag = 0
            cnt += 1
    
    print("#{} {}".format(test, cnt))