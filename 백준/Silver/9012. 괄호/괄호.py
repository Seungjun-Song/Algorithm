N = int(input())

for i in range(N):
    S = input()
    cnt = 0

    for j in range(len(S)):
        if S[j] == '(':
            cnt += 1
        elif S[j] == ')':
            cnt -= 1
            if cnt < 0:
                break

    if cnt == 0:
        print('YES')
    else:
        print('NO')