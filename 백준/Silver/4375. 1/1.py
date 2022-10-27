while 1:
    try:
        n = int(input())
    except:
        break

    num = '1'
    while 1:
        if int(num) % n == 0:
            print(len(num))
            break
        num += '1'