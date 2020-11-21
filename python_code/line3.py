def solution(n):
    answer = []
    if len(str(n)) == 1:
        answer = [0, n]
    else:
        first = dfs(n, 0)
        second = dfs2(n, 0)
        if first[0] < second[0]:
            answer = first
        else:
            answer = second

    return answer


def dfs(n, cnt):
    if len(str(n)) == 1:
        return [cnt, n]
    else:
        fi = int(str(n)[0])
        la = str(n)[1:]
        while la[0] == '0':
            la = la[1:]
            fi *= 10
        la = int(la)
        return dfs(fi + la, cnt + 1)


def dfs2(n, cnt):
    if len(str(n)) == 1:
        return (cnt, n)
    else:
        if len(str(n))>2:
            fi = int(str(n)[0:2])
            la = str(n)[2:]
            while la[0] == '0':
                la=la[1:]
                fi*=10
            la = int(la)
            return dfs2(fi + la, cnt + 1)
        else:
            fi = int(str(n)[0])
            la = str(n)[1:]
            while la[0] == '0':
                la=la[1:]
                fi*=10
            la = int(la)
            return dfs(fi + la, cnt + 1)

if __name__ == '__main__':
    print(solution(73425))
    print(solution(10007))
    print(solution(9))
