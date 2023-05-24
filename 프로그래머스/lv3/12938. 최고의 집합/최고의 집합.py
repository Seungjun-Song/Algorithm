def solution(n, s):
    if n > s:
        return [-1]
    answer = []
    arr = [s//n for _ in range(n)]
    
    for i in range(s%n):
        arr[i] += 1
    
    return sorted(arr)