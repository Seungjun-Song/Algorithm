import sys
n = int(sys.stdin.readline())
strow=[]
for i in range(n):
    strow.append(int(sys.stdin.readline()))
strow.sort()
len = len(strow)

for i in range(len-1, 1, -1):
    if strow[i] < strow[i-1]+strow[i-2]:
        print(strow[i]+strow[i-1]+strow[i-2])
        quit()
print(-1)