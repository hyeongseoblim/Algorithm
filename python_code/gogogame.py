import collections

global n, m, dy, dx, game_map, visit_map

dy = [-1, 0, 1, 0]
dx = [0, -1, 0, 1]

nm = list(map(int, input().split()))
n = nm[0]
m = nm[1]

game_map = [[0] * n for _ in range(m)]
visit_map = [[0] * n for _ in range(m)]


def solution():
    start_info = list(map(int, input().split()))
    y = start_info[0]
    x = start_info[1]

    dir = start_info[2]

    cnt = 0

    for i in range(n):
        input_line = list(map(int, input().split()))
        for j in range(m):
            game_map[i][j] = input_line[j]
            if (game_map[i][j] == 1):
                visit_map[i][j] = 2


    cnt = bfs(y, x, dir)

    return cnt


def bfs(y, x, dir):
    que = collections.deque()
    que.append([y, x])
    cnt = 0

    while (len(que) != 0):
        current = que.popleft()
        cy = current[0]
        cx = current[1]

        for i in range(4):
            dir = dir + 1
            if(dir == 4):
                dir = 0
            ny = cy + dy[dir]
            nx = cx + dx[dir]
            if (check(ny, nx)):
                que.append([ny, nx])
                visit_map[ny][nx] = 2
                cnt += 1
    return cnt


def check(y, x):
    if (y > n or x > m or y < 0 or x < 0 or visit_map[y][x] == 2 or game_map[y][x]==1):
        return False
    else:
        return True


if __name__ == '__main__':
    print(solution())
