def dfs(arr,s):
    if len(arr[s]) == 0:
        return 0

    if arr[s][0] != None:
        leftHeight = dfs(arr, arr[s][0]) + 1
    if arr[s][1] != None:
        rightHeight = dfs(arr,arr[s][1]) + 1

    return max(leftHeight, rightHeight)

def solution(t1, t2):
    arr =[[] for _ in range(len(t1))]
    ar2 = [[]for _ in range(len(t2))]
    for i in range(len(t1)):
        if t1[i][0] != -1:
            arr[i].append(t1[i][0])
        else:
            arr[i].append(None)
        if t1[i][1] !=-1:
            arr[i].append(t1[i][1])
        else:
            arr[i].append(None)
    for i in range(len(t2)):
        if t2[i][0] != -1:
            ar2[i].append(t2[i][0])
        else:
            ar2[i].append(None)
        if t2[i][1] !=-1:
            ar2[i].append(t2[i][1])
        else:
            ar2[i].append(None)

    print(dfs(arr,0))
    answer = -1
    return answer

if __name__ == '__main__':
    solution([[1,2],[3,4],[5,6],[-1,7],[8,9],[-1,-1],[-1,-1],[-1,-1],[-1,-1],[-1,-1]],[[1,2],[-1,-1],[-1,-1]])