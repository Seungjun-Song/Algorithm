N, M = map(int, input().split())
book = list(map(int, input().split()))

# book1에 양수, book2에 음수로 나눠 넣기
book1 = []
book2 = []
for i in range(N):
    if book[i] > 0:
        book1.append(book[i])
    else:
        book2.append(book[i])

# 절댓값이 큰 순서대로 더해주기
# M개의 책을 들 수 있으니 최대한 많은 책을 들고 다닌다고 가정
book1.sort(reverse=True)
book2.sort()
sum = 0
for i in range(0, len(book1), M):
    sum += book1[i] * 2
for i in range(0, len(book2), M):
    sum += abs(book2[i]) * 2

# 절댓값이 가장 큰 책은 마지막에 한 번만 가져다 준다고 가정(위의 과정에서 두 번 더해져있는 상태)
max = 0
for i in range(N):
    if abs(book[i]) > max:
        max = abs(book[i])
sum -= max

print(sum)