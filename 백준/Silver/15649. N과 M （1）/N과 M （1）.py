def answer(depth):
    if depth == M:
        print(' '.join(map(str, sequence)))
        return
    
    for i in range(1, N+1):
        if i not in sequence:
            sequence.append(i) 
            answer(depth+1)
            sequence.pop()

N, M = map(int ,input().split())
sequence = []
answer(0)