T = int(input())
for test in range(1, T+1):
    S = input()
    day = {"MON":0, "TUE":1, "WED":2, "THU":3, "FRI":4, "SAT":5, "SUN":6}
    if S == "SUN":
        print("#%d %d" % (test, 7))
    else:
        print("#%d %d" % (test, day["SUN"] - day[S]))