import itertools
def solution(s):
    result, last = 0,
    for c, g in itertools.groupby(s):
        leng = len(list(g))
        if c == 'a':
            if leng < 3:
                result += 2 - leng
            else:
                return -1
        else:
            result += 2 * (leng - (last == 'a'))
        last = c
    result += 2 * (s[-1] != 'a')
    return ans