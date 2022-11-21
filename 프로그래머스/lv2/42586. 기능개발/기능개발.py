def solution(progresses, speeds):
    answer = []

    progresses.reverse()
    speeds.reverse()
    while progresses:
        while progresses[len(progresses)-1] < 100:
            for i in range(len(progresses)):
                progresses[i] += speeds[i]
        
        cnt = 0
        while progresses[len(progresses)-1] >= 100:
            progresses.pop()
            cnt += 1

            if not progresses:
                break

        answer.append(cnt)
        
    return answer