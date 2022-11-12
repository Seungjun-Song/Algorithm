N = int(input())
A = int(N / 5)


while 1:
    B = int((N - A * 5) / 3)
    if((A * 5) + (B * 3) == N):
        print(A + B)
        break
    elif(A > 0):
        A -= 1
    else:
        print(-1)
        break