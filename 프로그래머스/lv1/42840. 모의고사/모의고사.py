def solution(answers):
    answer = []
    
    first = [1, 2, 3, 4, 5]
    second = [2, 1, 2, 3, 2, 4, 2, 5]
    third = [3, 1, 2, 4, 5]

    cnt = [0, 0, 0]
    for i in range(len(answers)):
        if answers[i] == first[i % 5]:
            cnt[0] += 1
        if answers[i] == second[i % 8]:
            cnt[1] += 1
        if answers[i] == third[(i // 2) % 5]:
            cnt[2] += 1
        
    for i in range(len(cnt)):
        if max(cnt) == cnt[i]:
            answer.append(i + 1)
    
    return answer