from collections import deque
import sys

def solution (line):

    stack = deque()
    for ap in line:
        if ap == '(':
            stack.append(ap)
        elif ap == ')':
            try:
                temp = stack.pop()
                if temp == '(':
                    continue
                else:
                    return 'no'
            except:
                return 'no'
        elif ap == '[':
            stack.append(ap)
        elif ap == ']':
            try:
                temp = stack.pop()
                if temp == '[':
                    continue
                else:
                    return 'no'
            except:
                return 'no'
        else:
            continue
    if(len(stack)>0):
        return 'no'
    else:
        return 'yes'
if __name__ == '__main__':
    for string in sys.stdin:
        line = string.strip().replace(" ","")
        if string[0] == '.':
            break
        res = solution(list(line))
        print(res)
