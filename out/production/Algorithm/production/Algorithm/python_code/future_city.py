import sys


global INF


if __name__ == '__main__':
    input = sys.stdin.readline
    INF = int(1e9)
    n,m = map(int,input().split())

    distance = [[INF] * (n+1) for _ in range(n+1)]

    for i in range(1,n+1):
        for j in range(1,n+1):
            if i == j :
                distance[i][j]=0

    for i in range(m):
        a,b = map(int,input().split())
        distance[a][b]=1
        distance[b][a]=1

    x, k = map(int,input().split())

    for i in range(1,n+1):
        for j in range(1, n + 1):
            for k in range(1, n + 1):
                distance[j][k]=min(distance[j][k],distance[j][i]+distance[i][k])



    res = distance[1][k]+distance[k][x]
    if res >= INF:
        print(-1)
    else:
        print(res)



