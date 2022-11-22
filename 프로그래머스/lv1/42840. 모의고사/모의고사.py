def solution(answers):
    answer = []
    
    first = []
    for i in range(1, 10001):
        if i % 5 == 0:
            first.append(5)
        else:
            first.append(i % 5)
        
    second = []
    temp = [1, 3, 4, 5]
    for i in range(10000):
        if i % 2 == 0:
            second.append(2)
        else:
            second.append(temp[(i % 8) // 2])
            
    third = []
    temp = [3, 1, 2, 4, 5]
    for i in range(0, 10000, 2):
        for _ in range(2):
            third.append(temp[(i % 10) // 2])
        
    one, two, three = 0, 0, 0    
    for i in range(len(answers)):
        if first[i] == answers[i]:
            one += 1
        if second[i] == answers[i]:
            two += 1
        if third[i] == answers[i]:
            three += 1
    
    if one == two == three:
        answer = [1, 2, 3]
    elif one == two and one > three:
        answer = [1, 2]
    elif one == three and one > two:
        answer = [1, 3]
    elif two == three and two > one:
        answer = [2, 3]
    elif one > two and one > three:
        answer = [1]
    elif two > one and two > three:
        answer = [2]
    elif three > one and three > two:
        answer = [3]
    
    return answer