def solution(s):
    answer = []
    s = (s[2:-2].split('},{'))
    s.sort(key = lambda x : len(x))
    for a in s:
        a = list(map(int, a.split(',')))
        for k in a:
            if k not in answer:
                answer.append(k)
            
    return answer