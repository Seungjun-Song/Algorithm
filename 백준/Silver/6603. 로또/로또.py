while 1:
    L = list(map(int, input().split()))
    if L == [0]:
        break

    k = L[0]
    S = L[1:]
    for a in range(k):
        for b in range(a+1, k):
            for c in range(b+1, k):
                for d in range(c+1, k):
                    for e in range(d+1, k):
                        for f in range(e+1, k):
                            print("{} {} {} {} {} {}".format(S[a], S[b], S[c], S[d], S[e], S[f]))
    print()