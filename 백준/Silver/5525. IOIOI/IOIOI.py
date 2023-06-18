N = int(input())
M = int(input())
S = input()

Pn = 'I' + 'OI'*N
i, cnt = 0, 0
while i < len(S):
    if Pn == S[i:i+len(Pn)]:
        cnt += 1
        i += 2
    else:
        i += 1
print(cnt)