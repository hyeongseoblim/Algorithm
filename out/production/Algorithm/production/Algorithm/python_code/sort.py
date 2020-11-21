def select_sort(arr):
    array = arr
    for i in range(len(array)):
        min_idx = i
        for j in range(i+1,len(array)):
            if array[min_idx] > array[j]:
                min_idx=j
        array[i],array[min_idx]=array[min_idx],array[i]
    return array

def insert_sort(arr):
    array = arr
    for i in range(1,len(array)):
        for j in range(i,0,-1):# i부터 1까지 감소하며 반복하는 문법.
            if array[j]<array[j-1]: #한칸씩 왼쪽으로 이동
                array[j],array[j-1] = array[j-1],array[j] #swap
            else:
                break
    return array
def quick_sort(arr, start,end):
    array = arr
    if start >= end:
        return
    pivot = start
    left = start+1
    right = end
    while left<=right:
        #pivot 보다 큰 데이터를 찾을 때 까지 반복
        while left <= end and array[left]<=array[pivot]:
            left+=1
        #pivot 보다 작은 데이터를 찾을 때 까지 반복
        while right > start and array[right]>= array[pivot]:
            right-=1
        #엇갈렸다면 작은 right -= 1 데이터와 pivot을 교체
        if left>right:
            array[right],array[pivot] = array[pivot],array[right]
        #엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
        else:
            array[right], array[left] = array[left],array[right]
    #분할 이후 왼쪽과 오른 쪽 각 부분에서 각각 정렬 수행
    quick_sort(arr, start,right-1)
    quick_sort(arr, right+1, end)

def quick_sort2(arr):
    if len(arr)<=1:
        return arr
    pivot = arr[0]
    tail = arr[1:]

    left_side = [x for x in tail if x<=pivot] #분할의 왼쪽
    right_side = [x for x in tail if x>pivot] #분할의 오른쪽

    #분할 이후의 왼쪽 부분과 오른쪽 부분에서 각각 정렬을 수행하고 전체 리스트를 반환
    return quick_sort2(left_side)+[pivot]+quick_sort2(right_side)

def count_sort(arr):
    count = [0]*(max(arr)+1)

    for i in range(len(arr)):
        count[arr[i]]+=1
    array= list()
    for i in range(len(count)):
        for j in range(count[i]):
            array.append(i)
    return array


if __name__ == '__main__':
    array = [5,1,2,8,7,3,4,9,6]
    print(array)
    print(select_sort(array))
    print(insert_sort(array))
    print(quick_sort2(array))
    print(count_sort(array))
    quick_sort(array, 0, len(array) - 1)
    print(array)

