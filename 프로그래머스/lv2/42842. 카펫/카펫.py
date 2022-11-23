def solution(brown, yellow):
    answer = []
    
    for w in range(brown//2):
        for h in range(brown//2):
            if brown == ((w*2) + ((h-2) * 2)) and yellow == ((w-2) * (h-2)):
                answer = [w, h]
                break
    
    return answer