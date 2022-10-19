#11170
T = int(input())
for _ in range(T):
    N, M = map(int, input().split())
    sum = 0
    for a in range(N, M+1):
        if '0' in str(a):
            sum += str(a).count('0')
    print(sum)