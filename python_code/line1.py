def solution(boxes):
    answer = -1
    arr = [0] * 1000001
    for i in range(len(boxes)):
        arr[boxes[i][0]] += 1
        arr[boxes[i][1]] += 1
    chk=0

    for j in arr:
        if (j // 2 ) >= 1 :
            chk+=(j//2)

    answer = len(boxes)-chk


    return answer


if __name__ == '__main__':
    print(solution([[1, 2], [2, 1], [3, 3], [4, 5], [5, 6], [7, 8]]))
    print(solution([[1, 2], [3, 4], [5, 6]]))
    print(solution([[1, 2], [2, 3], [3, 1]]))