import heapq

N = int(input())
heap = []
for _ in range(N):
    heapq.heappush(heap, int(input()))

while len(heap) > 1:
    min1 = heapq.heappop(heap)
    min2 = heapq.heappop(heap)
    heapq.heappush(heap, (min1+min2)/2)

print(heap[0])