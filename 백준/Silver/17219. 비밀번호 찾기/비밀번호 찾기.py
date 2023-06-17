N, M = map(int, input().split())
d = dict()
for _ in range(N):
    address, password = input().split()
    d[address] = password

for _ in range(M):
    address = input()
    print(d[address])