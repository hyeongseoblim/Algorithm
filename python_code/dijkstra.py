import sys

input = sys.stdin.readline

# 무한대값  설정
INF = int(1e9)

# 노드의 개수, 간선의 개수 입력받기
n, m = map(int, input().split())

# 시작 노드 번호
start = int(input())

# 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트
graph = [[] for i in range(n + 1)]

# 방문한 적이 있는지 체크하는 목적의 리스트
visited = [False] * (n + 1)
# 최단 거리 테이블
distance = [INF] * (n + 1)

for _ in range(m):
    a, b, c = map(int, input().split())
    # a번 노드에서 b번 노드로 가는 비용이 c
    graph[a].append((b, c))


# 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드를 반환하는 function
def get_smallest_node():
    min_value = INF
    index = 0  # 가장 최단 거리가 짧은 노드(인덱스)
    for i in range(1, n + 1):
        if distance[i] < min_value and not visited[i]:
            min_value = distance[i]
            index = i
    return index

def dijkstra(start):
    # start node reset

    distance[start]=0
    visited[start] = True
    for j in graph[start]:
        distance[j[0]]=j[1]
        #처음 시작 위치와 인접한 노드들 거리 값 지정

    #시작 노드를 제외한 전체 n01개의 노드에 대해서 반복
    for i in range(n-1):
        # 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
        now = get_smallest_node()
        visited[now] = True
        # 현재 노드와 연결된 다른 노드를 확인
        for k in graph[now]:
            cost  = distance[now]+k[1]
            # 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[k[0]]:
                distance[k[0]]=cost
dijkstra(start)

#모든 노드로 가기 위한 최단 거리를 출력

for i in range(1,n+1):
    # 도달할 수 없는 경우 INF 출력
    if distance[i] == INF:
        print('infinity')
    else:
        print(distance[i])
