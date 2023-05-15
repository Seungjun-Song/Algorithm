import math
def solution(n,a,b):
    
    answer = 1
    for i in range(n//2):
        
        if a%2 == 0 and a-1 == b:
            return answer
        elif a%2 != 0 and a+1 == b:
            return answer
        answer += 1
        a = math.ceil(a/2)
        b = math.ceil(b/2)
        