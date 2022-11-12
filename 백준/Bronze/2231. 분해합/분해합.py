N = int(input())

for i in range(1, N+1): # N+1 -> N
    A = list(map(int, str(i)))
    M = i + sum(A)
    if(M == N):
        print(i)
        break
    if(i == N):
        print(0)