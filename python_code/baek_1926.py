from collections import deque

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

n, m = map(int, input().split())
board = [[] for _ in range(n)]

for i in range(n):
    board[i] = list(map(int, input().split()))


def check(y, x):
    if y >= n or x >= m or x < 0 or y < 0:
        return False
    else:
        return True


def bfs(y, x, cnt):
    queue = deque()
    queue.append([y, x])
    board[y][x] = cnt
    res = 1
    while queue:
        size = len(queue)
        for i in range(size):
            now = queue.popleft()
            cy = now[0]
            cx = now[1]
            for j in range(4):
                ny = cy + dy[j]
                nx = cx + dx[j]
                if check(ny, nx):
                    if board[ny][nx] == 1:
                        board[ny][nx] = cnt
                        queue.append([ny, nx])
                        res += 1
    return res


if __name__ == '__main__':

    idx = 1
    result = 0
    for i in range(n):
        for j in range(m):
            if board[i][j] == 1:
                idx += 1
                result = max(result, bfs(i, j, idx))
    print(idx - 1)
    print(result)
