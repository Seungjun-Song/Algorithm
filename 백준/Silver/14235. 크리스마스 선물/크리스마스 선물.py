import heapq

n = int(input())
heap = []

for _ in range(n):
    nums = input()
    if nums == '0':
        if heap:
            print(heapq.heappop(heap)[1])
        else:
            print(-1)
    else:
        nums = list(map(int, nums.split()))
        for i in range(1, nums[0]+1):
            heapq.heappush(heap, (-nums[i], nums[i]))