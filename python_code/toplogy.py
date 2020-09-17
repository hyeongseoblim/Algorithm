from collections import deque

#위상 정렬 함수
def topology_sort(graph,indegree):
    result = [] #알고리즘 수행결과를 담을 리스트
    que =deque()

    #처음 진입시 진입차수 0인 노드 삽입
    for i in range(1,v+1):
        if indegree[i] == 0:
            que.append(i)
    while que:
        now = que.popleft()
        result.append(now)
        #연결 되있는 노드들의 진입차수 1감소
        for j in graph[now]:
            indegree[j]-=1
            #새롭게 진입차수가 0이되는 노드 큐에 삽입
            if indegree[j]==0:
                que.append(j)
    return result
if __name__ == '__main__':
    # 입력 받기
    v,e = map(int,input().split())
    #모든 노드에 대한 진입차수는 0으로 초기화
    indegree=[0]*(v+1)
    # 각 노드에 연결된 간선 정보를 담기 위한 연결리스트 초기화
    graph = [[]for i in range(v+1)]

    #방향 그래프의 모든 간선 정보를 입력받기
    for _ in range(e):
        a, b = map(int,input().split())
        graph[a].append(b)
        #진입차수를 1증가.
        indegree[b]+=1

    res = topology_sort(graph,indegree)
    print(res)
