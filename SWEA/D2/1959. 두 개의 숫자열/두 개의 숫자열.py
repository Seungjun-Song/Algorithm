T = int(input())
for test in range(1, T+1):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    answer = 0
    
    if len(A)-len(B) > 0:
        for i in range(len(A)-len(B)+1):
            temp = 0
            for j in range(len(B)):
                temp += A[j+i]*B[j]
            if answer < temp:
                answer = temp
    else:
        for i in range(len(B)-len(A)+1):
            temp = 0
            for j in range(len(A)):
                temp += A[j]*B[j+i]
            if answer < temp:
                answer = temp
    
    print("#{} {}".format(test, answer))