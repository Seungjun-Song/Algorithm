T = int(input())
for test in range(1, T+1):
    N = int(input())
    speed = 0
    distance = 0
    for _ in range(N):
        command = input()
        if command == '0':
            distance += speed
            continue
        
        command, acceleration = map(int, command.split())
        if command == 1:
            speed += acceleration
            distance += speed
        else:
            if speed - acceleration < 0:
                speed = 0
                continue
            speed -= acceleration
            distance += speed
    
    print('#%d %d' % (test, distance))