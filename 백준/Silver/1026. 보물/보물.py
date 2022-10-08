N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
sum = 0

for _ in range(N):
    sum += max(A) * min(B)
    A.remove(max(A))
    B.remove(min(B))

print(sum)