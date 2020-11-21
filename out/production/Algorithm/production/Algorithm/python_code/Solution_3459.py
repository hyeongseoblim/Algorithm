import sys
def solution(target):
    if target == 1:
        return 'Bob'
    elif target == 2 or target == 3:
        return 'Alice'
    answer = False
    turn = 1
    chk = 1
    while turn < target:
        if not answer:
            chk *= 4
        turn += chk
        answer= not answer




    if not answer :
        return 'Bob'
    else:
        return 'Alice'


if __name__ == '__main__':
    n = int(sys.stdin.readline().rstrip())
    for i in range(1,n+1):
        target = int(sys.stdin.readline().rstrip())
        print('#'+str(i)+" "+solution(target))

