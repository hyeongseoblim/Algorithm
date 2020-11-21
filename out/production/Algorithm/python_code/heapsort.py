import heapq


def heapsort(arr):
    h = list()
    result = list()


    for value in arr:
        heapq.heappush(h,value)
    for i in range(len(h)):
        result.append(heapq.heappop(h))

    return result


if __name__ == '__main__':
    result = heapsort([1,3,5,7,9,2,4,6,8,10])

    print(result)