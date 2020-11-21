west = 0
north = 1
east = 2
south = 3
isgo = 4

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]


def solution(maze):
    answer = 0
    st_x = 0
    st_y = 0
    n = len(maze)
    maze[n - 1][n - 1] = 'E'

    direction = nextDirection(st_x, st_y, maze)
    while (True):
        temp_x = st_x + dx[direction]
        temp_y = st_y + dy[direction]

        if temp_x == len(maze) - 1 and temp_y == len(maze) - 1 or maze[temp_y - 1][temp_x - 1] == 'E':
            break
        if temp_x < len(maze[0]) and temp_x >= 0:
            if (maze[temp_y][temp_x] == 1):
                direction = nextDirection(st_x, st_y, maze, direction)
                continue

            left = seeLeft(temp_x, temp_y, direction, maze)

            st_x = temp_x
            st_y = temp_y

            if left == '0' or left == "E":
                direction = (direction + isgo - 1) % 4
                answer += 1


    return answer


def nextDirection(st_x, st_y, maze, cur_dir=east):
    next_dir = None
    for j in range(len(dx)):
        d = (cur_dir + isgo - 1 + j) % 4
        ne_x = st_x + dx[d]
        ne_y = st_y + dy[d]
        if (ne_x >= len(maze[0]) or ne_x < 0) or (ne_y >= 7 or ne_y < 0):
            continue
        if (maze[ne_y][ne_x] == 0):
            next_dir = d
    return next_dir


def seeLeft(x, y, direction, maze):
    reverse = (direction + 2) % 4
    d = (reverse + 1) % 4

    nx = x + dx[d]
    ny = y + dy[d]

    return maze[ny][nx]


solution([[0, 1, 0, 1], [0, 1, 0, 0], [0, 0, 0, 0], [1, 0, 1, 0]])
