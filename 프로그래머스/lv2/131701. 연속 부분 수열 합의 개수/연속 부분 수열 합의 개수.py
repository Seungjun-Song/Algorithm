def solution(elements):
    answer = []
    
    a = 1
    l = len(elements)
    while a <= l:
        for i in range(len(elements)-a+1):
            answer.append(sum(elements[i:i+a]))
        
        elements.append(elements[a-1])
        a += 1
        # print(elements)
        # print(answer)
    return len(list(set(answer)))