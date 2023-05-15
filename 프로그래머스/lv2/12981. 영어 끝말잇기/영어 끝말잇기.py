import math
def solution(n, words):
    answer = []
    
    record = [words[0][0]]
    index = 1
    for word in words:
        
        if word in record or record[-1][-1] != word[0]:
            answer.append(index)
            answer.append(index)
            break
        index += 1
        record.append(word)
    print(record)
    if answer:
        answer[0] = answer[0]%n if answer[0]%n != 0 else n
        answer[1] = math.ceil(answer[1]/n) if answer[1]/n != 0 else n
    
    return answer if answer else [0, 0]