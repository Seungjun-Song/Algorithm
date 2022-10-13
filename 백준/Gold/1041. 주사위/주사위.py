import sys
input = sys.stdin.readline

N = int(input())
num = list(map(int, input().split()))

if N == 1:
    print(sum(num)-max(num))
else:
    arr = []
    arr.append(min(num[0], num[-1]))
    arr.append(min(num[1], num[-2]))
    arr.append(min(num[2], num[-3]))
    arr.sort()

    min1 = arr[0]
    min2 = arr[0]+arr[1]
    min3 = sum(arr)
    minValue = 0

    minValue += 4 * min2
    minValue += 4 * min3
    minValue += 4 * (N-2) * min1
    minValue += 4 * (N-2) * min2
    minValue += 4 * (N-2) * min2
    minValue += 5 * ((N-2)**2) * min1
    print(minValue)

# 꼭짓점(아래, 면2개) => 4개 고정
# 꼭짓점(위, 면3개) => 4개 고정

# 변(아래, 면1개) => (N-2)*4개
# 변(중간, 면2개) => (N-2)*4개
# 변(위, 면2개) => (N-2)*4개

# 중앙면(면 1개) => 5*((N-2)**2)개