ss = input()
PPAP = ['P', 'P', 'A', 'P']

stack = []
for s in ss:
    stack.append(s)
    if stack[-4:] == PPAP:
        for _ in range(4):
            stack.pop()
        stack.append('P')

if stack == ['P']:
    print("PPAP")
else:
    print("NP")