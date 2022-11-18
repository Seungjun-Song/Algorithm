T = int(input())
for test in range(1, T+1):
    N = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    answer = ""
    for i in range(N):
        answer += str(arr[i]) + " "

    print("#{} {}".format(test, answer))