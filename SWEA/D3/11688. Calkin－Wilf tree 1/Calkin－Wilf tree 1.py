T = int(input())
for test in range(1, T+1):
    direction = input()
    
    a, b = 1, 1
    for dir in direction:
        if dir == "L":
            b += a
        elif dir == "R":
            a += b
            
    print("#{} {} {}".format(test, a, b))