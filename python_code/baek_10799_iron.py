import sys
from collections import deque


def solution(line):
    stack = deque()
    result = 0
    for i in range(len(line)):
        if line[i] == '(':
            stack.append(line[i])
        else:
            if line[i-1] == '(':
                stack.pop()
                result += len(stack)
            else:
                stack.pop()
                result +=1

    return result


if __name__ == '__main__':
    line = list(sys.stdin.readline().rstrip())
    sys.stdout.write(str(solution(line)))
