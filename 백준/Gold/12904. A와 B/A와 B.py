S = list(input())
T = list(input())

while len(S) < len(T):
    if T[-1] == 'A':
        T.pop(-1)
    else:
        T.pop(-1)
        T.reverse()

if S == T:
    print(1)
else:
    print(0)