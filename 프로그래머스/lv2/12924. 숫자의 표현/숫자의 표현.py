def solution(n):
    answer = 0
    num = [i for i in range(1, 10001)]
    L, R = 0, 1
    while L<=n:
        if sum(num[L:R]) == n:
            answer += 1
            L += 1
        elif sum(num[L:R]) > n:
            L += 1
        else:
            R += 1
        
    return answer