N = int(input())

for i in range(1, N+1):
    nums = str(i)
    if '3' in nums or '6' in nums or '9' in nums:
        cnt = nums.count('3') + nums.count('6') + nums.count('9')
        for _ in range(cnt):
            print("-", end="")
        print(" ", end="")
    else:
        print(i, end=" ")