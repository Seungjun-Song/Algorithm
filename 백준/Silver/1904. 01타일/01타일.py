N = int(input())
arr = [1, 2]
for i in range(2, N):
    arr.append((arr[i-1] + arr[i-2])%15746)
print(arr[N-1])