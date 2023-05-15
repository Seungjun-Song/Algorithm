def gcd(a, b):
    while a%b != 0:
        a, b = b, a%b
    return b

def lcm(a, b):
    return a*b//gcd(a, b)

def solution(arr):
    answer = arr[0]
    for a in arr:
        answer = lcm(answer, a)
    
    return answer
