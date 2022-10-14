import sys
input = sys.stdin.readline

N, K = map(int, input().split())
Kindergarten = list(map(int, input().split()))
HeightDifference = []

for i in range(N-1):
    HeightDifference.append(Kindergarten[i+1]-Kindergarten[i])
HeightDifference.sort()

print(sum(HeightDifference[:N-K]))