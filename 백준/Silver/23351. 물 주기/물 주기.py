N, K, A, B = map(int, input().split())
flowerpot = list(K for _ in range(N))
day = 0

while min(flowerpot) != 0:

    for _ in range(A):
        flowerpot[flowerpot.index(min(flowerpot))] += B

    for i in range(N):
        flowerpot[i] -= 1

    day += 1

print(day)