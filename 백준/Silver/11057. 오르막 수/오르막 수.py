N = int(input())
arr = [[1 for _ in range(10)] for _ in range(N+1)]
for i in range(len(arr)):
    for j in range(len(arr[i])):
        if i != 0 and j != 0:
            arr[i][j] = arr[i-1][j] + arr[i][j-1]
print(arr[-1][-1]%10007)