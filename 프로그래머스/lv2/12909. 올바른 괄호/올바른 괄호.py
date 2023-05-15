def solution(s):
    answer = True
    
    q = []
    for i in s:
        if i == "(":
            q.append("(")
        else:
            if not q:
                answer = False
                break
            q.pop()

    return answer if not q else False