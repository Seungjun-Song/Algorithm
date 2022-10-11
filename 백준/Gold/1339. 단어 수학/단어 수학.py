N = int(input())
words = []
for i in range(N):
    words.append(list(input()))
    
alpha_num = {}
for word in words:
    for i in range(len(word)):
        if word[i] not in alpha_num:
            alpha_num[word[i]] = 10 ** (len(word)-1-i)
        else:
            alpha_num[word[i]] += 10 ** (len(word)-1-i)


alpha_num = sorted(alpha_num.items(), key=lambda x:x[1], reverse=True)
num = 9
sum = 0
for digit in alpha_num:
    sum += digit[1]*num
    num -= 1
print(sum)