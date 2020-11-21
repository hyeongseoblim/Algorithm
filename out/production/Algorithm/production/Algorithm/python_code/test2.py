def solution(arr):
    answer = []
    if len(arr) == 1:
        answer.append(-1)
        return answer
    else:
        minval = [1000000000,0]
        for i in range(len(arr)):
            if minval[0]>arr[i]:
                minval[0]=arr[i]
                minval[1]=i
        arr.pop(i)
        answer= arr
    return answer

print(solution([4,3,2,1]))