T = int(input())
for test in range(1, T+1):
    N = int(input())
    snail = [[0 for _ in range(N)] for _ in range(N)]
    
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    num = 1
    x, y = 0, 0
    direction = 0
    snail[x][y] = num

    while num != N ** 2:
        nx = x + dx[direction]
        ny = y + dy[direction]
        
        if 0 <= nx < N and 0 <= ny < N and snail[nx][ny] == 0:
            num += 1
            snail[nx][ny] = num
            x, y = nx, ny
        else:
            direction = (direction + 1) % 4

    print("#{}".format(test))    
    for i in range(N):
        print(*snail[i])