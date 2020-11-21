import sys


def dfs(val, n, m, r):
    if m == 0:
        return val % r
    dfs(val * n, n, m - 1, r)


if __name__ == '__main__':
    n, m, r = map(int, sys.stdin.readline().rstrip().split())
    res = dfs(n, n, m, r)
    print(res)
