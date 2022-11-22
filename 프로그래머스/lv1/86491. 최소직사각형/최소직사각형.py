def solution(sizes):
    answer = 0
    
    w, h = 0, 0
    for i in range(len(sizes)):
        if sizes[i][0] < sizes[i][1]:
            temp = sizes[i][1]
            sizes[i][1] = sizes[i][0]
            sizes[i][0] = temp
        if w < sizes[i][0]:
            w = sizes[i][0]
        if h < sizes[i][1]:
            h = sizes[i][1]
    
    answer = w * h
    return answer