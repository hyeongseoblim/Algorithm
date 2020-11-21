from sys import stdin


def find(parent, x):
    if parent[x] != x:
        return find(parent, parent[x])
    return parent[x]


def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)
    if a > b:
        parent[a] = b
    else:
        parent[b] = a


if __name__ == '__main__':
    input = stdin.readline

    n, m = map(int, input().split())

    parent = [0] * (n + 1)
    edges = list()
    result = 0
    for i in range(1, n + 1):
        parent[i] = i

    for i in range(m):
        a, b, cost = map(int, input().split())
        edges.append((cost, a, b))

    edges.sort()

    for edge in edges:
        cost, a, b = edge
        if find(parent, a) != find(parent, b):
            union(parent, a, b)
            result += cost
            last = cost


    print(result - last)
