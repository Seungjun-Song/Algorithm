T = int(input())
for _ in range(T):
    N = int(input())
    d = {}
    for _ in range(N):
        name, types = input().split()
        if types in d:
            d[types] = d[types] + [name]
        else:
            d[types] = [name]
    
    answer = 1
    for a in d.values():
        answer *= len(a)+1
    
    print(answer-1)