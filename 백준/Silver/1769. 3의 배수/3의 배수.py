def f(x):
    global cnt
    if len(x) != 1:
        cnt += 1
        sum = 0
        for a in x:
            sum += int(a)
        f(str(sum))
    else:
        if int(x) % 3 == 0:
            print(cnt)
            print("YES")
        else:
            print(cnt)
            print("NO")

X = input()
cnt = 0
f(X)