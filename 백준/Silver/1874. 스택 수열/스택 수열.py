N = int(input())
stack = []
answer = []
count = 1
flag = True

for i in range(N):
    num = int(input())
    while count <= num:
        answer.append("+")
        stack.append(count)
        count += 1
    if stack[-1] == num:
        answer.append("-")
        stack.pop()
    else:
        flag = False

if flag == False:
    print("NO")
else:
    for i in answer:
        print(i)