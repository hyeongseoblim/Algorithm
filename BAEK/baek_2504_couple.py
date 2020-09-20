from sys import stdout, stdin
from collections import deque


def solution(line):
    stack = deque()
    result = 0
    for i in range(len(line)):
        if line[i] == ')':
            temp = 0
            while stack:
                top = stack.pop()
                if top == '(':
                    if temp == 0:
                        stack.append(2)
                    else:
                        stack.append(2*temp)
                    break
                elif top == '[':
                    return 0
                else:
                    if temp == 0:
                        temp = int(top)
                    else:
                        temp += int(top)
        elif line[i] == ']':
            temp = 0
            while stack:
                top = stack.pop()
                if top == '[':
                    if temp == 0:
                        stack.append(3)
                    else:
                        stack.append(3 * temp)
                    break
                elif top == '(':
                    return 0
                else:
                    if temp == 0:
                        temp = int(top)
                    else:
                        temp += int(top)
        else:
            stack.append(line[i])

    for i in stack:
        if i == '(' or i =='[':
            return 0
        else:
            result += i
    return result


if __name__ == '__main__':

        line = list(stdin.readline().rstrip())
        print(str(solution(line)))
