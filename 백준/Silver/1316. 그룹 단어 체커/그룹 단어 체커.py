N = int(input())

cnt = 0
for _ in range(N):
    words = input()
    error = 0
    
    for idx in range(len(words)-1):
        if words[idx] != words[idx+1]:
            newWords = words[idx+1:]
            if newWords.count(words[idx]) > 0:
                error += 1
    if error == 0:
        cnt += 1
    
print(cnt)