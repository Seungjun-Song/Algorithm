s = input()
ss = []
for i in s:
    if not ss:
        ss.append(i)
    if ss[-1] != i:
        ss.append(i)
print(min(ss.count('0'), ss.count('1')))