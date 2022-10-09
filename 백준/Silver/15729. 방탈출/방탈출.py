N = int(input())
A_list = list(0 for _ in range(N))
B_list = list(map(int, input().split()))
cnt = 0

for i in range(N):
    if A_list[i] != B_list[i]:
        A_list[i] = 1 - A_list[i]
        if i < N-1:
            A_list[i+1] = 1 - A_list[i+1]
        if i < N-2:
            A_list[i+2] = 1 - A_list[i+2]

        cnt += 1

print(cnt)