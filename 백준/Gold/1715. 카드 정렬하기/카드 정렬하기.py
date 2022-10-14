import heapq, sys
input = sys.stdin.readline

N = int(input())
card = list(int(input()) for _ in range(N))
heapq.heapify(card)

if len(card) == 1:
    print(0)
else:
    cnt = 0
    while len(card) > 1: #1개일 경우 비교하지 않아도 된다
        temp_1 = heapq.heappop(card) #제일 작은 덱
        temp_2 = heapq.heappop(card) #두번째로 작은 덱
        cnt += temp_1 + temp_2 #현재 비교 횟수를 더해줌
        heapq.heappush(card, temp_1 + temp_2) #더한 덱을 다시 넣어줌
    
    print(cnt)