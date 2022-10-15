N = int(input())
nums = [int(input()) for _ in range(N)]
left = []
right = []

sum = 0
for num in nums:
    if num > 1:
        right.append(num)
    elif num == 1:
        sum += 1
    else:
        left.append(num)

left.sort()
if len(left)%2 == 0:
    for i in range(0, len(left), 2):
        sum += left[i]*left[i+1]
else:
    for i in range(0, len(left)-1, 2):
        sum += left[i]*left[i+1]
    sum += left[-1]

right.sort(reverse=True)
if len(right)%2 == 0:
    for i in range(0, len(right), 2):
        sum += right[i]*right[i+1]
else:
    for i in range(0, len(right)-1, 2):
        sum += right[i]*right[i+1]
    sum += right[-1]

print(sum)