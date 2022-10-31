N = int(input())
i = j = 1
while i*j < N:
    if i > j:
        j += 1
    else:
        i += 1
print(i, j)