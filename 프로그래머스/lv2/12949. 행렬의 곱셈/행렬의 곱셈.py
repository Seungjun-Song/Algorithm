def solution(arr1, arr2):
    answer = []
    for i in range(len(arr1)):
        summ = []
        for j in range(len(arr2[0])):
            temp = []
            for k in range(len(arr1[0])):
                temp.append(arr1[i][k] * arr2[k][j])
            summ.append(sum(temp))
        answer.append(summ)
            
    return answer

0,0 * 0,0 + 0,1 * 1,0
0,0 * 0,1 + 0,1 * 1,1
1,0 * 0,0 + 1,1 * 1,0
1,0 * 0,1 + 1,1 * 1,1
2,0 * 0,0 + 2,1 * 1,0
2,0 * 0,1 + 2,1 * 1,1