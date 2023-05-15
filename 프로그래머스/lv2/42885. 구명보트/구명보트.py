from collections import deque
def solution(people, limit):
    answer = 0
    people = deque(sorted(people))
    while people:
        answer += 1
        if people[0]+people[-1] > limit:
            people.pop()
        else:
            people.pop()
            if people:
                people.popleft()
        
    return answer