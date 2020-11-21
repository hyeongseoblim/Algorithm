from collections import deque
import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    n = int(input())
    result=""
    for i in range(n):
        line = list(input().rstrip())
        deq = deque()
        flag=True
        for i in line:
            if i=="(":
                deq.append(i)
            elif i == ")":
                if deq:
                    deq.pop()
                else:
                    flag=False
                    break
        if deq or not flag:
            result="NO"
        elif not deq and flag:
            result="YES"
        print(result)