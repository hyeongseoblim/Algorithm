from collections import deque
import copy
global dy,dx,n,m,visit,juice_case,juice_case2

dy = [-1,1,0,0]
dx = [0,0,-1,1]

def check(y,x):
    if y >= n or x >= m or x < 0 or y < 0:
        return False
    else:
        return True


def bfs(start):
    que = deque([start])
    juice_case[start[0]][start[1]]=2
    while que:
        yx = que.popleft()
        y = yx[0]
        x = yx[1]
        if y>=n or x>=m or x<0 or y <0:
            return False
        for i in range(4):
            ny = y+dy[i]
            nx = x+dx[i]
            if check(ny,nx):
                if juice_case[ny][nx]==0:
                    juice_case[ny][nx]=2
                    que.append([ny,nx])
    return True

def dfs(y,x):
    if check(y,x):
        if juice_case2[y][x]==0:
            juice_case2[y][x]=1
            for i in range(4):
                dfs(y+dy[i],x+dx[i])
            return True
        return False
    else:
        return False




if __name__ == '__main__':
    n,m = map(int, input().split())


    juice_case = list()
    for i in range(n):
        juice_case.append((list(map(int,input()))))
    juice_case2 = copy.deepcopy(juice_case)
    cnt =0
    k = n-1
    e = m-1
    for i in range(k):
        for j in range(e):
            if (juice_case[i][j]==0):
                if(bfs([i,j])):
                    cnt+=1

    cnt_2 =0
    print("\n")
    for i in range(k):
        for j in range(e):
            if (juice_case2[i][j] == 0):
                if (dfs(i, j)):
                    cnt_2 += 1



    print(cnt,cnt_2)


#
# 15 14
# 00000111100000
# 11111101111110
# 11011101101110
# 11011101100000
# 11011111111111
# 11011111111100
# 11000000011111
# 01111111111111
# 00000000011111
# 01111111111000
# 00011111111000
# 00000001111000
# 11111111110011
# 11100011111111
# 11100011111111