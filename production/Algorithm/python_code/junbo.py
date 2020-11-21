import sys
import heapq

global INF


def dijkstra(arr, start, distance):
    que = list()
    distance[start] = 0
    heapq.heappush(que, (0, start))
    while que:
        dist, now = heapq.heappop(que)

        if distance[now] < dist:
            continue
        for i in arr[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(que, (cost, i[0]))

    cnt = 0
    max_val = 0
    for i in range(2, len(distance)):
        if distance[i] == INF:
            continue
        cnt += 1
        max_val = max(max_val,distance[i])

    return (cnt,max_val)


if __name__ == '__main__':
    INF = int(1e9)
    input = sys.stdin.readline

    n, m, c = map(int, input().split())

    distance = [INF] * (n + 1)

    info = [[] for _ in range(n + 1)]

    for _ in range(m):
        x, y, z = map(int, input().split())
        info[x].append((y, z))

    res = dijkstra(info, c, distance)

    print(res[0],res[1])
