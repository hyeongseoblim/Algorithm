import collections

global n, m, dx, dy

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def solution(board, r, c):
    n = len(board)
    m = len(board[0])

    visit = [[False] * n for _ in range(m)]
    tcnt=0
    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] == 0:
                visit[i][j] = True
                tcnt +=1
    cnt = 0
    if board[r][c] != 0:
        result = bfs(r, c, board[r][c], board, visit)
        tcnt+=2
    else:
        starting = bfs_value(r,c,board,visit)
        cnt += starting[3]
        result = bfs(starting[1], starting[2], starting[0],board,visit)
        tcnt+=2
    while result:
        if tcnt == 16:
            break
        cnt+=result[0]
        starting = bfs_value(result[1],result[2],board,visit)
        cnt += starting[3]
        result = bfs(starting[1], starting[2], starting[0], board, visit)
        tcnt+=2
    answer = cnt
    return answer


def bfs(x, y, value, board, visit):
    n = len(board)
    m = len(board[0])

    queue = collections.deque()
    visit[x][y] = True
    queue.append((x, y))
    cnt = 0
    while queue:
        size = len(queue)
        for _ in range(size):
            x, y = queue.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if ny >= n or nx >= m or nx < 0 or ny < 0:
                    continue
                else:
                    if board[ny][nx] == value and visit[ny][nx]==False:
                        visit[ny][nx] = True
                        cnt+=1
                        return [cnt, ny,nx]
                    else:
                        queue.append((ny, nx))
        cnt += 1
    return False


def bfs_value(r,c,board,visit):
    value = 0
    n = len(board)
    m = len(board[0])
    que = collections.deque()
    que.append((r,c))
    cnt = 0
    while que:
        size = len(que)
        for _ in range(size):
            yx = que.popleft()
            y = yx[0]
            x = yx[1]
            if y >= n or x >= m or x < 0 or y < 0:
                return False
            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                if ny >= n or nx >= m or nx < 0 or ny < 0:
                    continue
                else:
                    if board[ny][nx] == 0:
                        que.append([ny, nx])
                    else:
                        if visit[ny][nx] == False:
                            value = board[ny][nx]
                            cnt+=1
                            return [value, ny, nx, cnt]
        cnt += 1


if __name__ == '__main__':
    # print(solution([[1, 0, 0, 3], [2, 0, 0, 0], [0, 0, 0, 2], [3, 0, 1, 0]], 1, 0))
    print(solution([[3, 0, 0, 2], [0, 0, 1, 0], [0, 1, 0, 0], [2, 0, 0, 3]], 0, 1))
