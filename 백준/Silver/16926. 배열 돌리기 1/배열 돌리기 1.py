from sys import stdin

n, m, r = map(int, stdin.readline().split())
arr = []
for i in range(n):
    arr.append(list(map(int, stdin.readline().split())))

for _ in range(r):
    for i in range(min(n, m) // 2):
        x, y = i, i
        value = arr[x][y]

        for j in range(i + 1, n - i):  # 좌
            x = j
            prev_value = arr[x][y]
            arr[x][y] = value
            value = prev_value

        for j in range(i + 1, m - i):  # 하
            y = j
            prev_value = arr[x][y]
            arr[x][y] = value
            value = prev_value

        for j in range(i + 1, n - i):  # 우
            x = n - j - 1
            prev_value = arr[x][y]
            arr[x][y] = value
            value = prev_value

        for j in range(i + 1, m - i):  # 상
            y = m - j - 1
            prev_value = arr[x][y]
            arr[x][y] = value
            value = prev_value

for i in arr:
    print(*i)