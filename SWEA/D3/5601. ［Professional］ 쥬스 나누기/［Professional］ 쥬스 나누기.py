T = int(input())
for test in range(1, T+1):
    N = int(input())  
        
    print('#{} '.format(test), end="")
    for _ in range(N):
        print('{}/{}'.format(1, N), end=" ")
    print()