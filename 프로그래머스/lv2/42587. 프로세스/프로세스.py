from collections import deque
def solution(priorities, location):
    answer = 0
    q = deque(priorities)
    while q:
        # print(q, location, answer)
        if q[0] == max(q):
            q.popleft()
            answer += 1
            if location == 0:
                break
        else:
            q.append(q.popleft())
        location -= 1
        if location < 0:
            location = len(q)-1
            
    return answer