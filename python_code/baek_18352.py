from collections import deque
from sys import stdin

if __name__ == '__main__':
    n, m, k, x = map(int, stdin.readline().split())

    graph = [[] for _ in range(n + 1)]
    visit = [-1] * (n + 1)
    for i in range(m):
        a, b = map(int, stdin.readline().split())
        graph[a].append(b)
    result = deque()
    cnt = 1
    visit[x]=0
    result.append(x)
    while result:
            now = result.popleft()
            for i in graph[now]:
                if visit[i] == -1:
                    visit[i] = visit[now]+1
                    result.append(i)
    check = False
    for i in range(1,len(visit)):
        if visit[i] == k:
            print(i)
            check =True
    if not check :
        print(-1)