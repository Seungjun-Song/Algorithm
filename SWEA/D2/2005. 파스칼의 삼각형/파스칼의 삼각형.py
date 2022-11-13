T = int(input())
for test in range(1, T+1):
    print("#%d" % test)
    N = int(input())
    pascal = [[0 for _ in range(N)] for _ in range(N)]
    
    for i in range(N):
        for j in range(i+1):
            if j == 0 or j == i:
                pascal[i][j] = 1
            else:
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j]
    
    for i in range(N):
        for j in range(i+1):
            if pascal[i][j] != 0:
                print(pascal[i][j], end=" ")
        print()