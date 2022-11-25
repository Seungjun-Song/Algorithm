def solution(numbers, target):
    answer = dfs(0, numbers, target)
    return answer

def dfs(depth, numbers, target):
    answer = 0
    if depth == len(numbers):
        if sum(numbers) == target:
            return 1
        else:
            return 0
    
    answer += dfs(depth+1, numbers, target)
    numbers[depth] *= -1
    answer += dfs(depth+1, numbers, target)
    return answer