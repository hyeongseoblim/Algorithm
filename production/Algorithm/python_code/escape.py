import math
from collections import deque
from copy import deepcopy

global n, m, mini,dy, dx, miro
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]


def check(y, x):
    if y >= n or x >= m or y < 0 or x < 0:
        return False
    else:
        return True


def dfs(y, x, cnt):
    global mini
    if (y == n - 1 and x == m - 1):
        mini = min(mini,cnt)
        return mini
    else:
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if (check(ny, nx) and miro[ny][nx] == 1 and visit[ny][nx]==False):
                visit[ny][nx]=True
                dfs(ny, nx, cnt + 1)
                visit[ny][nx]=False
def bfs(start):
    que = deque([start])
    cnt = 1
    while que:
        size = len(que)
        for i in range(size):
            now = que.popleft()
            cy = now[0]
            cx = now[1]
            if(cy==n-1 and cx == m-1):
                return cnt
            for i in range(4):
                ny = cy+dy[i]
                nx = cx+dx[i]
                if check(ny,nx) and miro[ny][nx]==1 and visit2[ny][nx]==False:
                    visit2[ny][nx]=True
                    que.append([ny,nx])
        cnt+=1
if __name__ == '__main__':
    n, m = map(int, input().split())

    miro = list()
    visit = list([False]*m for _ in range(n))

    for i in range(n):
        miro.append(list(map(int, input())))
    mini = 999999999
    visit[0][0]=True
    visit2 = deepcopy(visit)
    result = dfs(0, 0, 0)
    result2 = bfs([0,0])
    print(result)
    print(result2)
