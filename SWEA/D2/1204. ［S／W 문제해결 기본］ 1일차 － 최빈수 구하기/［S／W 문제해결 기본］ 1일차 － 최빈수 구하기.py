T = int(input())
for test in range(1, T+1):
    n = int(input())
    score = list(map(int, input().split()))
    
    cnt = [0] * 101
    for s in score:
        cnt[s] += 1

    for i in range(len(cnt)-1, -1, -1):
        if cnt[i] == max(cnt):
            answer = i
            break
        
    print("#%d %d" % (test, answer))