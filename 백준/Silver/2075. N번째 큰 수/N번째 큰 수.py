import heapq

N = int(input())
heap = list(map(int, input().split()))
for _ in range(N-1):
    nums = list(map(int, input().split()))
    for num in nums:
        heapq.heappush(heap, num)
    for _ in range(N):
        heapq.heappop(heap)

print(heap[0])