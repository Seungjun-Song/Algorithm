def solution(routes):
    answer = 0
    routes.sort()
    m = -30000
    print(routes)
    for i, j in routes:
        if i > m:
            m = j
            answer += 1
        m = min(m, j)
    return answer