def rotate(arr):
    n = len(arr)
    m = len(arr[0])
    res = [[0] * n for _ in range(m)]
    for i in range(n):
        for j in range(m):
            res[j][n - 1 - i] = arr[i][j]

    return res


def check(arr):
    n = len(arr)//3
    for i in range(n, n * 2):
        for j in range(n, n * 2):
            if arr[i][j] != 1:
                return False
    return True

def solution(key, lock):
    n = len(lock)
    m = len(key)
    extend_map = [[0] * n * 3 for _ in range(n * 3)]
    for i in range(n):
        for j in range(n):
            extend_map[i + n][j + n] = lock[i][j]
    for ro in range(4):
        key = rotate(key)
        for i in range(n * 2):
            for j in range(n * 2):
                for k in range(m):
                    for l in range(m):
                        extend_map[i + k][j + l] += key[k][l]
                if check(extend_map) == True:
                    return True
                for k in range(m):
                    for l in range(m):
                        extend_map[i + k][j + l] -= key[k][l]

    return False


