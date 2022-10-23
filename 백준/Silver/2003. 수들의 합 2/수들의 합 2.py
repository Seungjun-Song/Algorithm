N, M = map(int, input().split())
num = list(map(int, input().split()))

left = 0
right = 1
cnt = 0
while left <= right and right <= N:
    temp = num[left:right]
    
    if sum(temp) < M:
        right += 1
    elif sum(temp) == M:
        cnt += 1
        right += 1
    else:
        left += 1

print(cnt)