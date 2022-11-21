def solution(s):
    answer = True

    if s[0] == ")":
        return False

    arr = []
    for i in s:
        if i == "(":
            arr.append(i)
        else:
            if len(arr) == 0:
                return False
            arr.pop()

    if len(arr) != 0:
        answer = False
    
    return answer