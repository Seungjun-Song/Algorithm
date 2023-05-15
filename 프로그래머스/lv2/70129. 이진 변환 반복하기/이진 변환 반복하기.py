def solution(s):
    cnt, cnt_zero = 0, 0
    
    while s != '1':
        cnt += 1
        cnt_zero += s.count('0')
        s = "".join(i for i in s if i != '0')
        s = format(len(s), 'b')
        
    return [cnt, cnt_zero]