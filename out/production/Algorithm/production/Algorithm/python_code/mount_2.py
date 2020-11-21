

def solution(arr):
    answer = []
    temp = quadtree(arr,0,0,len(arr))
    one =0
    zero =0
    for i in temp:
       if  i == '1':
           one+=1
       else:
           zero+=1

    answer.append(zero)
    answer.append(one)
    return answer


def quadtree(matrix, start_x, start_y, n):
    temp = matrix[start_x][start_y]
    rtn = []
    for i in range(n):
        for j in range(n):
            if temp != matrix[start_x + i][start_y + j]:
                rtn.extend(solve(matrix,start_x, start_y, n))
                return rtn
    return str(temp)


def solve(matrix,start_x: int, start_y: int, n: int):
    result = []
    result.extend(quadtree(matrix,start_x, start_y, n // 2))
    result.extend(quadtree(matrix,start_x, start_y + n // 2, n // 2))
    result.extend(quadtree(matrix,start_x + n // 2, start_y, n // 2))
    result.extend(quadtree(matrix,start_x + n // 2, start_y + n // 2, n // 2))
    return result


print(solution([[1, 1, 0, 0], [1, 0, 0, 0], [1, 0, 0, 1], [1, 1, 1, 1]]))
