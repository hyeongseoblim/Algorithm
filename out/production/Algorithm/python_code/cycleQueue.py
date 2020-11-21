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
            idx =1
            while not find == que[idx]:
                idx+=1
            if len(que)-idx >mid:
                que.rotate(-idx)
            else:
                idx = len(que)-idx
                que.rotate(idx)
            cnt+=idx
            que.popleft()
    return cnt


if __name__ == '__main__':
    print(solution())
