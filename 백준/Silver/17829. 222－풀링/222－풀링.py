N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]

while N > 1:
    new_graph = []
    for i in range(0, N, 2):
        temp = []
        for j in range(0, N, 2):
            num = sorted([graph[i][j], graph[i][j+1], graph[i+1][j], graph[i+1][j+1]])
            temp.append(num[-2])
        new_graph.append(temp)
    
    graph = new_graph
    N //= 2

print(graph[0][0])