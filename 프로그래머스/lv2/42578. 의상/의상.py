def solution(clothes):
    answer = 1
    dic = {type : [] for _, type in clothes}
    for name, type in clothes:
        dic[type].append(name)
    
    for i in dic.values():
        answer *= len(i)+1
    
    return answer-1