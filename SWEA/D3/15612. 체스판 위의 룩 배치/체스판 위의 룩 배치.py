T = int(input())
for test in range(1, T+1):
    chess = [input() for _ in range(8)]
    check = True
    
    # 행 단위로 O 체크    
    for i in range(8):
        if chess[i].count('O') != 1:
            check = False
            break
    
    # 열 단위로 O 체크
    rook = [0] * 8
    for i in range(8):
        for j in range(8):
            if chess[i][j] == 'O':
                if rook[j] == 1:
                    check = False
                    break
                rook[j] = 1
    
    if check:
        print("#%d yes" % test)
    else:
        print("#%d no" % test)