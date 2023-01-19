A, B, C = map(int, input().split())
X, Y, Z = map(int, input().split())

cnt = 0
for _ in range(3):
    chicken = min(A, X)
    cnt += chicken
    A -= chicken
    X -= chicken

    pizza = min(B, Y)
    cnt += pizza
    B -= pizza
    Y -= pizza

    hamburger = min(C, Z)
    cnt += hamburger
    C -= hamburger
    Z -= hamburger

    X, Y, Z = Z//3, X//3, Y//3

print(cnt)