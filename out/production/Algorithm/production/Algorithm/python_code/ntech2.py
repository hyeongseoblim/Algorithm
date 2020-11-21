def solution(histogram):
    res =0
    for i in range(len(histogram)):
        for j in range(i+1,len(histogram)):
            start = histogram[i]
            end = histogram[j]
            total_height = 0
            upper_bound = min(start, end)
            total_height = upper_bound*(j-i-1)
            res = max(total_height,res)
    return res


if __name__ == '__main__':
    # print(solution([2, 2, 2, 3]	))
    print(solution([6, 5, 7, 3, 4, 2]))