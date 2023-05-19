def solution(triangle):
    answer = 0
    arr = triangle
    for i in range(1, len(triangle)):
        for j in range(len(triangle[i])):
            if j == 0:
                arr[i][j] += triangle[i-1][j]
            elif j == len(triangle[i])-1:
                arr[i][j] += triangle[i-1][j-1]
            else:
                if arr[i-1][j-1] > arr[i-1][j]:
                    arr[i][j] += arr[i-1][j-1]
                else:
                    arr[i][j] += arr[i-1][j]
        
    return max(arr[-1])
