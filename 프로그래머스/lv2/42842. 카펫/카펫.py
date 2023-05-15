def solution(brown, yellow):
    answer = []
    
    for w in range(brown//2):
        for h in range(brown//2):
            if w*h == brown+yellow and w>=h and (w-2)*(h-2)==yellow:
                return w, h
    