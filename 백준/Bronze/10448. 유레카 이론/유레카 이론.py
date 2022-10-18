triangularnum = [n*(n+1)//2 for n in range(1, 45)]

Eureka = [0] * 1001
for i in triangularnum:
    for j in triangularnum:
        for k in triangularnum:
            if i+j+k <= 1000:
                Eureka[i+j+k] = 1

T = int(input())
for _ in range(T):
    print(Eureka[int(input())])