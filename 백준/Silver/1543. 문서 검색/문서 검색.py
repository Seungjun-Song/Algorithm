words = input()
word = input()

cnt = 0
i = 0
while i <= len(words) - len(word):
    if words[i: i+len(word)] == word:
        cnt += 1
        i = i+len(word)
    else:
        i += 1
print(cnt)