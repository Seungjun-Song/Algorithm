T = int(input())
for test in range(1, T+1):
    alphabet = [chr(i) for i in range(97, 123)]
    ss = input()
    
    alpha = 97
    answer = 0
    for s in ss:
        if s == chr(alpha):
            alpha += 1
            answer += 1
        else:
            break
    
    print("#%d %d" % (test, answer))