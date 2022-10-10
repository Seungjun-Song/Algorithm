N, M = map(int, input().split())
A = list(list(map(int, input())) for _ in range(N))
B = list(list(map(int, input())) for _ in range(N))
cnt = 0

def Rmatrix(x, y):
    for i in range(3):
        for j in range(3):
            A[x+i][y+j] = 1 - A[x+i][y+j]

def check():
    for i in range(N):
        for j in range(M):
            if A[i][j] != B[i][j]:
                return False
    return True
    
for i in range(N-2):
    for j in range(M-2):
        if A[i][j] != B[i][j]:
            Rmatrix(i, j)
            cnt += 1
if check():
    print(cnt)
else:
    print(-1)