N = int(input())
M = int(input())
S = input()

Pn = 'I'
for _ in range(N):
    Pn += 'OI'

cnt = 0
for i in range(M-N*2):
    if Pn == S[i:i+N*2+1]:
        cnt += 1
print(cnt)