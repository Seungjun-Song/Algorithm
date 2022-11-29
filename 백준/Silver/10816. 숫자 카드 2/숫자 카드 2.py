from sys import stdin
N = int(stdin.readline())
list1 = list(map(int, input().split()))
M = int(stdin.readline())
list2 = list(map(int, input().split()))

hash = {}

for i in list1:
    if i in hash:
        hash[i] += 1
    else:
        hash[i] = 1

for i in list2:
    if i in hash:
        print(hash[i], end=" ")
    else:
        print(0, end=" ")
