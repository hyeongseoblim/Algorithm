import sys

global INF

if __name__ == '__main__':
    INF = int(1e9)
    input = sys.stdin.readline

    n,m = map(int,input().split())

    graph = [[INF] * (n+1) for _ in range(n+1)]
    # 자기 자신은 0으로 초기화
    for a in range(1, n+1):
        for b in range( 1, n+1):
            if a==b :
                graph[a][b]=0

    #그래프에 대한 정보값 입력 받기
    for _ in range(m):
        a, b, c = map(int,input().split())
        graph[a][b]=c
    #점화식에 따른 플로이드 워셜 알고리즘 수행
    for i in range(1, n+1): # 거쳐갈 node
        for j in range(1, n+1): # j > k         j > i > k
            for k in range( 1, n+1):
                graph[j][k]=min(graph[j][k],(graph[j][i]+graph[i][k]))

    for k in range(1, n+1):
        for j in range(1, n+1):
            if graph[k][j]==INF:
                print("INFINITY")
            else:
                print(graph[k][j])