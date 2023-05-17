from collections import deque
def solution(s):
    answer = 0
    s = deque(s)
    
    for _ in range(len(s)):
        check = deque()
        flag = True
        for a in s:
            
            if not check:
                check.append(a)
                continue
            if a == '[' or a == '(' or a == '{':
                check.append(a)
            else:
                if a == ']':
                    if check[-1] == '[':
                        check.pop()
                    else:
                        check.append(a)
                elif a == ')':    
                    if check[-1] == '(':
                        check.pop()
                    else:
                        check.append(a)
                elif a == '}':    
                    if check[-1] == '{':
                        check.pop()
                    else:
                        check.append(a)
        if not check:
            answer += 1
        
        s.append(s.popleft())
            
    
    return answer