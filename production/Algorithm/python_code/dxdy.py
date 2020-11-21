def check(y, x, n):
    if (y > n or x > n or y == 0 or x == 0):
        return False
    else:
        return True


def solution():
    dx = (0, 0, -1, 1)
    dy = (-1, 1, 0, 0)

    n = int(input())

    keyword = list((input().split()))
    move_type = ['U','D','L','R']

    y,x,ey,ex = 1,1,1,1
    for key in keyword:
        for i in range(len(move_type)):
            if key == move_type[i]:
                nx = ex+dx[i]
                ny = ey+dy[i]
                if(check(nx,ny,n)):
                    ey,ex = ny,nx



    for i in range(len(keyword)):
        if keyword[i] == 'L':
            if (check(y + dy[2], x + dx[2], n)):
                y += dy[2]
                x += dx[2]
        elif keyword[i] == 'R':
            if (check(y + dy[3], x + dx[3], n)):
                y += dy[3]
                x += dx[3]
        elif keyword[i] == 'U':
            if (check(y + dy[0], x + dx[0], n)):
                y += dy[0]
                x += dx[0]
        else:
            if (check(y + dy[1], x + dx[1], n)):
                y += dy[1]
                x += dx[1]
    return (x,y, ex,ey)



if __name__ == '__main__':
    print(solution())
