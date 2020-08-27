from collections import deque


def solution():
    n, m = map(int, input().split())

    que = deque()
    for i in range(n):
        que.append(i + 1)
    find_idx = list(map(int, input().split()))
    cnt = 0
    for i in range(len(find_idx)):
        find = find_idx[i]
        mid = int(len(que) / 2)
        if find == que[0]:
            que.popleft()
        else:
            while not find == que[0]:
                if find < que[mid]:
                    while not find == que[0]:
                        end = que.popleft()
                        que.append(end)
                        cnt += 1
                if find >= que[mid]:
                    while not find == que[0]:
                        start = que.pop()
                        que.appendleft(start)
                        cnt += 1

            que.popleft()
    return cnt


if __name__ == '__main__':
    print(solution())
