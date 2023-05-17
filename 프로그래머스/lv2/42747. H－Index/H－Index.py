def solution(citations):
    answer = 0
    citations.sort(reverse=True)
    
    for i in range(len(citations), -1, -1):
        cnt = 0
        for cit in citations:
            if i <= cit:
                cnt += 1
        
        if i <= cnt and i >= len(citations)-cnt:
            answer = i
            break
            
    return answer