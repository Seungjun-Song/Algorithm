def solution(operations):
    q = []
    for oper in operations:
        op, num = oper.split()
        if op == 'I':
            q.append(int(num))
        else:
            if q:
                if num == '1':
                    q.remove(max(q))
                else:
                    q.remove(min(q))
        
    return [max(q), min(q)] if q else [0, 0]