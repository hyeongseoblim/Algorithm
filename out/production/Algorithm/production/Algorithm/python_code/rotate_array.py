def rotate_matrix(arr):
    row_length = len(arr)
    col_length = len(arr[0])

    res = [[0]* row_length for _ in range(col_length)]

    for row in range(row_length):
        for col in range(col_length):
            res[col][row_length-1-row]=arr[row][col]

    return res

if __name__ == '__main__':
    n,m = map(int,input().split())

    arr =list([] for _ in range(n))

    idx =0
    for i in range(n):
        for j in range(m):
            arr[i].append(idx)
            idx+=1

    arr = rotate_matrix(arr)

    for i in range(n):
        print(arr[i])
