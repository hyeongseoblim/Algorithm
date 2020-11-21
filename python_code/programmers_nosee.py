from collections import deque


def solution(n, edge):
    answer = 0
    graph = [[] for _ in range(n + 1)]
    for i in edge:
        a = i[0]
        b = i[1]
        graph[a].append(b)
        graph[b].append(a)
    visit = [False] * (n + 1)

    que = deque()
    for i in graph[1]:
        que.appendleft(i)
        visit[i]=True
    visit[1] = True

    while que:
        size = len(que)
        for i in range(size):
            now = que.pop()
            for i in graph[now]:
                if not visit[i]:
                    visit[i] = True
                    que.appendleft(i)

        answer = size
    return answer


if __name__ == '__main__':
    arr = [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]
    print(solution(6, arr))
    arr2 = [[1,2],[1,3],[2,3]]
    print(solution(3,arr2))