N = int(input())
trees = list(map(int, input().split()))

if sum(trees)%3 == 0:
    cnt = 0
    for tree in trees:
        cnt += tree // 2
    if cnt >= sum(trees)/3:
        print("YES")
    else:
        print("NO")
else:
    print("NO")