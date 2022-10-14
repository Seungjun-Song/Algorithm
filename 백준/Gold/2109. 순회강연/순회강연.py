import heapq

n = int(input())
lecture = [list(map(int, input().split())) for _ in range(n)]
lecture = sorted(lecture, key=lambda x:x[1])

heap = []
for i in lecture:
    heapq.heappush(heap, i[0])
    if len(heap) > i[1]:
        heapq.heappop(heap)

print(sum(heap))