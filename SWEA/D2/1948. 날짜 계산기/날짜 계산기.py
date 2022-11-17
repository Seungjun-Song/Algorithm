T = int(input())
for test in range(1, T+1):
    M1, D1, M2, D2 = map(int, input().split())
    day = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    day1 = sum(day[:M1]) + D1
    day2 = sum(day[:M2]) + D2    
        
    print('#%d %d' % (test, day2 - day1 + 1))