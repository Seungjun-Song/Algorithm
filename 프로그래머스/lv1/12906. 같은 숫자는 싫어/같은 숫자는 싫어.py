def solution(arr):
    answer = []
    
    answer.append(arr[0])
    for i in arr:
        temp = answer.pop()
        if temp == i:
            answer.append(temp)
            continue
        answer.append(temp)
        answer.append(i)

    return answer