import math
sosu = []
for i in range(2, 123456*2):
    flag = True
    for j in range(2, int(math.sqrt(i)) + 1):
        if i % j == 0:
            flag = False
            break
    if flag:
        sosu.append(i)

while True:
    n = int(input())
    if n == 0:
        break
    
    cnt = 0
    for i in sosu:
        if n < i and i <= 2*n:
            cnt += 1
    
    print(cnt)