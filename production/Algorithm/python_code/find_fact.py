from sys import stdin, stdout

def use_counting_sort(arr,arr2):
    counting_array = [0]*100000
    answer = list()
    for i in arr:
        counting_array[i]+=1

    for j in arr2:
        if counting_array[j] == 0:
            answer.append('no')
        else:
            answer.append('yes')

    return answer

def binary_search(arr, target, start, end):
    if start>end:
        return -1
    mid = (start+end)//2

    if arr[mid] == target:
        return mid
    elif arr[mid] > target:
        return binary_search(arr,target,start,mid-1)
    else:
        return binary_search(arr,target,mid+1,end)

def use_set_search(arr,arr2):
    fact_set = set()
    answer = list()
    for i in arr:
        fact_set.add(i)
    for j in arr2:
        if j in fact_set:
            answer.append('yes')
        else:
            answer.append('no')
    return answer


def solution(arr,arr2):
    answer = list()
    arr.sort()
    for i in arr2:
        if binary_search(arr,i,0,len(arr)-1) == -1:
            answer.append('no')
        else:
            answer.append('yes')

    return answer


if __name__ == '__main__':
    n = int(stdin.readline().rstrip())
    fact_line = list(map(int,stdin.readline().rstrip()))
    m = int(stdin.readline().rstrip())
    find_line = list(map(int,stdin.readline().rstrip()))

    print(solution(fact_line,find_line))
    print(use_set_search(fact_line,find_line))
    print(use_counting_sort(fact_line,find_line))