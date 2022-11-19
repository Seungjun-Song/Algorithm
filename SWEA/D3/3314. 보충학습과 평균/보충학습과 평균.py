T = int(input())
for test in range(1, T+1):
    score = list(map(int, input().split()))
    for i in range(len(score)):
        if score[i] < 40:
            score[i] = 40
        
    print('#{} {}'.format(test, sum(score) // len(score)))