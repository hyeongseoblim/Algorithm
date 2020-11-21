import heapq
import sys

global INF


def dijkstra(start):
    que = list()
    heapq.heappush(que, (0, start))
    distance[start] = 0
    while que:  # 큐가 비어있지 않는동안
        # 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        dist, now = heapq.heappop(que)
        # 현재 노드가 이미 처리된 적이 있는 노드라면 무시
        if distance[now] < dist:
            continue
        # 현재 노드와 연결된 다른 인접한 노드들을 확인한다.
        for i in graph[now]:
            cost = dist + i[1]
            # 현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧은 경n 우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(que, (cost, i[0]))


if __name__ == '__main__':
    input = sys.stdin.readline
    INF = int(1e9)

    #node, edge
    n,m = map(int,input().split())
    #start node
    start = int(input())
    #empty list by node to node
    graph = [[] for i in range(n+1)]
    #min-value distance list
    distance = [INF]*(n+1)

    for _ in range(m):
        a, b, c = map(int,input().split())
        # a node to b / cost = c
        graph[a].append((b,c))

    dijkstra(start)

    for i in range(1,n+1):
        if distance[i] == INF:
            print("INFINITY")
        else:
            print(distance[i])

