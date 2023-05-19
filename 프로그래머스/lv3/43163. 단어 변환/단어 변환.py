from collections import deque
def solution(begin, target, words):
    answer = 0
    if target not in words:
        return 0
    q = deque()
    q.append([begin, 0])
    visited = [False] * len(words)
    while q:
        # print(q)
        word, depth = q.pop()
        if word == target:
            answer = depth
            break
        
        for i in range(len(words)):
            if not visited[i]:
                cnt = 0
                for j in range(len(word)):
                    if word[j] != words[i][j]:
                        cnt += 1
                if cnt == 1:
                    visited[i] = True
                    q.append([words[i], depth+1])
    return answer