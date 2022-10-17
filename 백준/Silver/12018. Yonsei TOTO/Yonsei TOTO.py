n, m = map(int, input().split())
answer = []

for _ in range(n):
    Pi, Li = map(int, input().split())
    Mileage = list(map(int, input().split()))
    Mileage.sort(reverse=True)
    if len(Mileage) < Li:
        answer.append(1)
    else:
        answer.append(Mileage[Li-1])

answer.sort()
cnt = 0
for a in answer:
    m -= a
    cnt += 1
    if m < 0:
        print(cnt-1)
        break
if m > 0:
    print(cnt)