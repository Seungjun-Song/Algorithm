for _ in range(10):
    test = input()
    N, M = map(int, input().split())
    
    print("#{} {}".format(test, N ** M))