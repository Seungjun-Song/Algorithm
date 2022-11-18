T = int(input())
for test in range(1, T+1):
    s = input()
    s = s.replace("a", "")
    s = s.replace("e", "")
    s = s.replace("i", "")
    s = s.replace("o", "")
    s = s.replace("u", "")
    
    print("#{} {}".format(test, s))