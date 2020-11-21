from collections import deque
import sys
from itertools import combinations
import copy

n, m = map(int, sys.stdin.readline().split())

area = [[] for _ in range(n)]

for i in range(n):
    area[i] = list(map(int, sys.stdin.readline().split()))

dy = [-1,1,0,0]
dx = [0,0,-1,1]

def check(y, x):
    if y >= n or x >= m or x < 0 or y < 0:
        return False
    else:
        return True


def pandamic(board,virus):
    que = deque()
    for vir in virus:
        que.append(vir)
    while que:
        size = len(que)
        for i in range(size):
            now =  que.popleft()
            cy = now[0]
            cx = now[1]
            for dir in range(4):
                ny = cy+dy[dir]
                nx = cx+dx[dir]
                if check(ny,nx):
                    if board[ny][nx] == 0:
                        board[ny][nx]=2
                        que.append([ny,nx])
    cnt = 0
    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] == 0:
                cnt +=1
    return cnt



if __name__ == '__main__':
    virus = list()
    isZero = list()
    for i in range(len(area)):
        for j in range(len(area[i])):
            if area[i][j] == 2:
                virus.append([i, j])
            elif area[i][j] == 0:
                isZero.append([i, j])
    buildwall = list(combinations(isZero, 3))
    res = 0
    for chance in buildwall:
        temp = copy.deepcopy(area)
        for idx in chance:
            y = idx[0]
            x = idx[1]
            temp[y][x] = 1
        res = max(res, pandamic(temp,virus))
    print(res)