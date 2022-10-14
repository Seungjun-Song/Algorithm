import heapq

N = int(input())
dasom = int(input())
candidate = [int(input()) for _ in range(N-1)]

heap = []
for c in candidate:
    heapq.heappush(heap, (-c, c))

if len(heap) == 0:
    print(0)
else:
    cnt = 0
    while True:
        max = heapq.heappop(heap)[1]
        if max >= dasom:
            dasom += 1
            heapq.heappush(heap, (-max+1, max-1))
            cnt += 1
        else:
            break
    print(cnt)