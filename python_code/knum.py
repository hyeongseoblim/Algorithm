def solution(array, commands):
    answer = []
    for i in commands:
        a=i[0]-1
        b=i[1]
        c=i[2]-1
        temp = array[a:b]
        temp.sort()
        answer.append(temp[c])
    return answer

print(solution([1, 5, 2, 6, 3, 7, 4],[[2, 5, 3], [4, 4, 1], [1, 7, 3]]))