N = int(input())
K = int(input())
sensor = sorted(list(map(int, input().split())), reverse=True)

if N >= K:    
    distance = []
    for i in range(N-1):
        distance.append(sensor[i] - sensor[i+1])

    for _ in range(K-1):
        distance.remove(max(distance))

    print(sum(distance))
else:
    print(0)