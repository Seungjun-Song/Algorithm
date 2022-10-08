N, K = map(int, input().split())
location = list(input())
cnt = 0

for i in range(N):
    if location[i] == 'P':
        for j in range(max(i-K, 0), min(i+K+1, N)):
            if location[j] == 'H':
                location[j] = 0
                cnt += 1
                break
            
print(cnt)