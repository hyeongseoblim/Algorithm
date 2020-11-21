from collections import deque
import sys
import copy


def toplogoy_sort(graph, indegree, time):
    result = copy.deepcopy(time)
    que = deque()

    for i in range(1, len(indegree)):
        if indegree[i] == 0:
            que.append(i)
    while que:
        now = que.popleft()
        result.append(now)
        for i in graph[now]:
            result[i] = max(result[i], result[now] + time[i])
            indegree[i] -= 1
            if indegree[i] == 0:
                que.append(i)

    for i in range(1, v + 1):
        print(result[i])


if __name__ == '__main__':
    input = sys.stdin.readline

    v = int(input())
    indegree = [0] * (v + 1)
    time = [0] * (v + 1)
    graph = [[] for _ in range(v + 1)]

    for i in range(1,v+1):
        data = list(map(int, input().split()))
        time[i] = data[0]
        for x in data[1:-1]:
            indegree[i] += 1
            graph[x].append(i)
    toplogoy_sort(graph,indegree,time)