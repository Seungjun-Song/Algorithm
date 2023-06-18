N = int(input())
M = int(input())
broken = list(map(str, input().split())) if M > 0 else []
answer = abs(100 - N)

for num in range(1000000):
    for n in str(num):
        if n in broken:
            break
    else:
        answer = min(answer, len(str(num))+abs(num-N))
    
print(answer)