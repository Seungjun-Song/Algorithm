def solution(m, n, puddles):
    dp = [[0] * (m+1) for _ in range(n+1)]
    for d in dp:
        print(d)
    
    for i in range(1, n+1):
        for j in range(1, m+1):
            # print(i, j)
            if [j, i] in puddles:
                continue
            elif i == 1 and j == 1:
                dp[i][j] = 1
            else:
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
            # for d in dp:
            #     print(d)
    
    return dp[-1][-1] % 1000000007