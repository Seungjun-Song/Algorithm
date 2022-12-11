N = int(input())
card = list(map(int, input().split()))
M = int(input())
sangun = list(map(int, input().split()))
card.sort()

for i in sangun:
    start = 0
    end = N-1
    check = True
    while start <= end:
        mid = (start+end) // 2
        
        if i == card[mid]:
            print(1, end=" ")
            check = False
            break
        elif i < card[mid]:
            end = mid - 1
        else:
            start = mid + 1
    
    if check:
        print(0, end=" ")