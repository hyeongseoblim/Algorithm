from collections import deque
import re
if __name__ == '__main__':
    flag = True
    cnt = 1
    while flag:
        line = input()
        temp = ''
        if line[0]=='-':
            break
        while temp != line:
            temp = line
            line = re.sub('{}', '', line)
        if len(line) == 0:
            print(str(cnt)+'. 0')
        else:
            que =deque()
            res = 0
            for i in line:
                if i == '}':
                    if len(que) ==0:
                        res+=1
                        que.append("{")
                    else:
                        que.pop()
                else:
                    if len(que) != 0:
                        res+=1
                        que.pop()
                    else:
                        que.append(i)
            print(str(cnt)+". "+str(res))
        cnt+=1





