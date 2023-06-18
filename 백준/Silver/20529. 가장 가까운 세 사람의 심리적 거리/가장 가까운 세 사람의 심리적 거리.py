T = int(input())
for _ in range(T):
    N = int(input())
    arr = list(input().split())
    
    if N > 32:
        print(0)
    else:
        answer = 2e9
        for i in range(N):
            for j in range(i+1, N):
                for k in range(j+1, N):
                    cnt = 0
                    for x in range(4):
                        if arr[i][x] != arr[j][x]:
                            cnt += 1
                        if arr[i][x] != arr[k][x]:
                            cnt += 1
                        if arr[j][x] != arr[k][x]:
                            cnt += 1
                        if cnt >= answer:
                            break
                    if answer > cnt:
                        answer = cnt
        
        print(answer)