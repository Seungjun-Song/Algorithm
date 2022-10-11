N, M = map(int, input().split())
book = list(map(int, input().split()))
book1 = []
book2 = []

for i in range(N):
    if book[i] > 0:
        book1.append(book[i])
    else:
        book2.append(book[i])

book1.sort(reverse=True)
book2.sort()
sum = 0
for i in range(0, len(book1), M):
    sum += book1[i] * 2
for i in range(0, len(book2), M):
    sum += abs(book2[i]) * 2

max = 0
for i in range(N):
    if abs(book[i]) > max:
        max = abs(book[i])

sum -= max
print(sum)