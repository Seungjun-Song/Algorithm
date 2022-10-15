import heapq

T = int(input())
for _ in range(T):
    K = int(input())
    heap = list(map(int, input().split()))
    heapq.heapify(heap)
    
    sum = 0
    while len(heap) > 1:
        min1 = heapq.heappop(heap)
        min2 = heapq.heappop(heap)
        
        sum += min1+min2
        heapq.heappush(heap, min1+min2)
    
    print(sum)