import heapq
import sys

global INF



def solution(n, s, a, b, fares):
    answer = 0
    INF = int(1e9)
    # empty list by node to node
    graph = [[INF] * (n + 1) for _ in range(n + 1)]
    # 자기 자신은 0으로 초기화
    for idx in range(1, n + 1):
        graph[idx][idx] = 0
    for i in range(len(fares)):
        graph[fares[i][0]][fares[i][1]]=fares[i][2]
        graph[fares[i][1]][fares[i][0]]=fares[i][2]

    for i in range(1, n+1): # 거쳐갈 node
        for j in range(1, n+1): # j > k         j > i > k
            for k in range(1, n+1):
                graph[j][k]=min(graph[j][k],(graph[j][i]+graph[i][k]))


    min_v = graph[s][1]+graph[1][a]+graph[1][b]
    for i in range(2,n+1):
        min_v = min(min_v,(graph[s][i]+graph[i][a]+graph[i][b]))


    answer =  min_v
    return answer

if __name__ == '__main__':
    print(solution(6,4,6,2,[[4, 1, 10], [3, 5, 24], [5, 6, 2], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]))
    print(solution(7,3,4,1,[[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]))
