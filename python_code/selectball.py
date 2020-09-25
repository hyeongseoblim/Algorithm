from itertools import combinations
if __name__ == '__main__':
    n,m = map(int, input().split())
    balls = list(map(int,input().split()))
    for i in range(len(balls)):
        balls[i] = (i+1,balls[i])
    res = list(combinations(balls,2))

    result = 0

    for i in res:

        if i[0][1] == i[1][1]:
            continue
        else:
            result+=1

    print(result)