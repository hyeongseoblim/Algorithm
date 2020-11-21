from collections import deque

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

n, m = map(int, input().split())
board = [[] for _ in range(n)]
visit = [[False]*m for _ in range(n)]
for i in range(n):
    board[i] = list(map(int, input()))


def check(y, x):
    if y >= n or x >= m or x < 0 or y < 0:
        return False
    else:
        return True


def bfs(y, x):
    queue = deque()
    queue.append([y, x])
    res = 1
    visit[y][x]=True
    while queue:
        size = len(queue)
        for i in range(size):
            now = queue.popleft()
            cy = now[0]
            cx = now[1]
            for j in range(4):
                ny = cy + dy[j]
                nx = cx + dx[j]
                if ny == n - 1 and nx == m - 1:
                    res += 1
                    return res
                if check(ny, nx) and not visit[ny][nx]:
                    if board[ny][nx] == 1:
                        visit[ny][nx] =True
                        queue.append([ny, nx])
        res += 1
    return res


if __name__ == '__main__':
    cnt = bfs(0, 0)
    print(cnt)