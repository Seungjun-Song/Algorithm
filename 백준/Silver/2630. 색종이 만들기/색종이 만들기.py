def confetti(N, x, y):
    for i in range(x, x+N):
        for j in range(y, y+N):
            if array[i][j] != array[x][y]:
                confetti(N//2, x, y)
                confetti(N//2, x+N//2, y)
                confetti(N//2, x, y+N//2)
                confetti(N//2, x+N//2, y+N//2)
                return
    
    if array[x][y] == 0:
        paper[0] += 1
    else:
        paper[1] += 1                

N = int(input())
array = [list(map(int, input().split())) for _ in range(N)]
paper = [0, 0]
confetti(N, 0, 0)
print(paper[0])
print(paper[1])