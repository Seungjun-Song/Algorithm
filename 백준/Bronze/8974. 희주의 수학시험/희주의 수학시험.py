A, B = map(int, input().split())
sequence = []
for i in range(1, 46):
    for j in range(i):
        sequence.append(i)

sum = 0
for i in range(A-1, B):
    sum += sequence[i]
print(sum)