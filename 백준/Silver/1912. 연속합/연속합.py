N = int(input())
arr = list(map(int, input().split()))

answer = [arr[0]]
for i in range(N-1):
    answer.append(max(answer[i] + arr[i+1], arr[i+1]))

print(max(answer))