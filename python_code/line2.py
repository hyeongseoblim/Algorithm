from collections import deque


def solution(ball, order):
    answer = []
    pipe = deque(ball)
    order = deque(order)
    delay = list()

    while pipe:
        left = pipe[0]
        right = pipe[-1]
        for i in range(len(delay)):
            if right in delay:
                answer.append(pipe.pop())
                delay.remove(right)
                if len(pipe) > 0:
                    right = pipe[-1]
            elif left in delay:
                answer.append(pipe.popleft())
                delay.remove(left)
                if len(pipe) > 0:
                    left = pipe[0]

        now = order.popleft()
        if left == now:
            answer.append(left)
            pipe.popleft()
        elif right == now:
            answer.append(right)
            pipe.pop()

        else:
            delay.append(now)


    return answer

if __name__ == '__main__':
    print(solution([1, 2, 3, 4, 5, 6], [6, 2, 5, 1, 4, 3]))
    print(solution([11, 2, 9, 13, 24], [9, 2, 13, 24, 11]))
