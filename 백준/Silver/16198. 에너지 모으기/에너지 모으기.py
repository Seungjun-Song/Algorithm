def dfs(energy):
    global maxEnergy
    if len(marble) == 2:
        if maxEnergy < energy:
            maxEnergy = energy
            return
    
    for i in range(1, len(marble)-1):
        sum = marble[i-1] * marble[i+1]
        temp = marble[i]
        del marble[i]
        dfs(energy + sum)
        marble.insert(i, temp)
    
N = int(input())
marble = list(map(int, input().split()))
maxEnergy = 0
dfs(0)
print(maxEnergy)