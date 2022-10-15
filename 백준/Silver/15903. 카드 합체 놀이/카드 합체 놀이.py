import heapq

n, m = map(int, input().split())
heap = list(map(int, input().split()))
heapq.heapify(heap)

for _ in range(m):
    min1 = heapq.heappop(heap)
    min2 = heapq.heappop(heap)
    plus = min1 + min2
    heapq.heappush(heap, plus)
    heapq.heappush(heap, plus)

print(sum(heap))