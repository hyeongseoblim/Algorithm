from collections import deque


dy = (0, -1, 0, 1)
dx = (-1, 0, 1, 0)


def solution():
    n = int(input())
    k = int(input())

    board = [[0] * n for _ in range(n)]

    for i in range(k):
        a, b = map(int, input().split())
        board[a-1][b-1] = 1
    board[0][0] = 2
    start_dir = 2
    snake = deque()
    snake.appendleft([0,0])
    y = 0
    x = 0
    now = 0

    l = int(input())
    for i in range(l):
        times, dir = input().split()
        times = int(times)
        for time in range(now, times):
            now += 1
            ny = y + dy[start_dir]
            nx = x + dx[start_dir]
            if ny >= n or nx >= n or nx < 0 or ny < 0:
                return now
            else:
                if board[ny][nx] == 2:
                    return now
                else:
                    if board[ny][nx] == 1:
                        board[ny][nx] = 2
                        snake.appendleft((ny, nx))
                    else:
                        prev = snake.popleft()
                        cy = prev[0]
                        cx = prev[1]
                        board[ny][nx] = 2
                        board[cy][cx] = 0
                        snake.append((ny, nx))
                        if len(snake)>1:
                            for i in range(1,len(snake)):
                                board[cy][cx] = 2
                                snake.append((cy,cx))
                                prev = snake.popleft()
                                cy = prev[0]
                                cx = prev[1]
                                board[cy][cx] = 0

                    y = ny
                    x = nx

        if dir == 'L':
            start_dir -= 1
            if start_dir == -1:
                start_dir = 3
        else:
            start_dir += 1
            if start_dir == 4:
                start_dir = 0

    while not (ny >= n or nx >= n or nx < 0 or ny < 0):
        now += 1
        ny = y + dy[start_dir]
        nx = x + dx[start_dir]
        if board[ny][nx] == 2:
            return now
        else:
            if board[ny][nx] == 1:
                board[ny][nx] = 2
                snake.appendleft((ny, nx))
            else:
                prev = snake.popleft()
                cy = prev[0]
                cx = prev[1]
                board[ny][nx] = 2
                board[cy][cx] = 0
                snake.append((ny, nx))
                if len(snake) > 1:
                    for i in range(1, len(snake)):
                        board[cy][cx] = 2
                        snake.append((cy, cx))
                        prev = snake.popleft()
                        cy = prev[0]
                        cx = prev[1]
                        board[cy][cx] = 0
            y = ny
            x = nx

    return now


if __name__ == '__main__':
    print(solution())
