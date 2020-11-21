def solution(location):
    dy = [-2,-2,2,2,-1,1,-1,1]
    dx = [-1,1,-1,1,-2,-2,2,2]

    cnt = 0
    y = location[0]
    x = location[1]

    for i in range(8):
        ny = y + dy[i]
        nx = x + dx[i]
        if(check(ny,nx)):
            cnt+=1

    return cnt

def check(y,x):
    if(y>8 or x>8 or x<0 or y < 0 ):
        return False
    else:
        return True

if __name__ == '__main__':
    location = input()

    y = int(ord(location[0]))-int(ord('a'))
    x=  int(location[1])-1
    loc = [y,x]
    print(solution(loc))