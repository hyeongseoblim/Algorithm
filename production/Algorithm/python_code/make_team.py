import sys


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
    n, m = map(int, sys.stdin.readline().split())

    student = [0] * (n + 1)

    for i in range(len(student)):
        student[i] = i

    for i in range(m):
        func, a, b = map(int, sys.stdin.readline().split())
        if func == 0:
            union(student,a,b)
        else:
            a=find(student,a)
            b=find(student,b)
            if a == b:
                print("YES")
            else:
                print("NO")