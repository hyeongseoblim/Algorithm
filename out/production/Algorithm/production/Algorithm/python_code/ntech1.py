def solution(flowers):
    answer = 0

    arr = [0]* 366
    for i in flowers:
        start = i[0]
        end = i[1]
        for j in range(start,end):
            arr[j]+=1
    for i in arr:
        if i > 0:
            answer +=1
    return answer
if __name__ == '__main__':
    print(solution([[2, 5], [3, 7], [10, 11]]))
    print(solution([[3, 4],[4, 5], [6, 7], [8, 10]]))