from itertools import permutations

N = int(input())
num = list(permutations([i for i in range(1, 10)], 3))

cnt = 0
for i in range(N):
    throw, strike, ball = map(int, input().split())
    throw = list(map(int, str(throw)))
    r_cnt = 0

    for i in range(len(num)):
        s, b = 0, 0
        i -= r_cnt
        for j in range(3):
            if throw[j] == num[i][j]:
                s += 1
            else:
                if throw[j] in num[i]:
                    b += 1
        
        if s != strike or b != ball:
            num.remove(num[i])
            r_cnt += 1
    
print(len(num))