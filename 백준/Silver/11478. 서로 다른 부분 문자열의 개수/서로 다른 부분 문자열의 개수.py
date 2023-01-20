S = input()
answer = []

for i in range(len(S)):
    for j in range(i+1, len(S)+1):
        answer.append(S[i:j])

print(len(set(answer)))