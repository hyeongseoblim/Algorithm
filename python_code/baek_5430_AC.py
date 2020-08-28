import sys


def solution(comm, n, arr):
    state = False
    comm = comm.replace("RR", "")
    left = 0
    right = 0
    for com in comm:
        if com == 'D':
            if  not state:
                left += 1
            else:
                right += 1
        else:
            state = not state
    if left+right > n:
        return 'error\n'
    else:
        rest = arr[left:n - right]
        if state:
            return '[' + ','.join(rest[::-1]) + ']\n'
        else:
            return '[' + ','.join(rest) + ']\n'


if __name__ == '__main__':
    test = int(sys.stdin.readline().rstrip())

    for _ in range(test):
        command = sys.stdin.readline().rstrip()
        size = int(sys.stdin.readline().rstrip())

        array = list(sys.stdin.readline().rstrip()[1:-1].split(','))
        if size == 0:
            array = list()
        res = str(solution(command, size, array))
        sys.stdout.write(res)
