T = int(input())
for test in range(1, T+1):
    arr = list(map(int, input().split()))
    arr.remove(max(arr))
    arr.remove(min(arr))
    answer = round(sum(arr) / 8)
            
    print("#%d %d" % (test, answer))