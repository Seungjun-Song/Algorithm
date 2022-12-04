import math
M = int(input())
N = int(input())

arr = []
for i in range(M, N+1):
    flag = True
    if i > 1:
        for j in range(2, int(math.sqrt(i) + 1)):
            if i % j == 0:
                flag = False
                break
        
        if flag:
            arr.append(i)

if arr:
    print(sum(arr))
    print(min(arr))
else:
    print(-1)