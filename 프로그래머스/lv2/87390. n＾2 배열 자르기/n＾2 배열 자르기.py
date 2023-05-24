def solution(n, left, right):
    answer = []
    
    for i in range(left, right+1):
        answer.append(max(i//n, i%n)+1)
    
    return answer

# 123 223 333
# 1234 2234 3334 4444
# 12345 22345 33345 44445 55555