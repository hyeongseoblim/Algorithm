def solution(n):
    cnt = 0
    for i in range(n+1):
        for j in range(60):
            for k in range(60):
                #if (('3' in str(i)) or ('3' in str(j)) or ('3' in str(k))):
                if('3' in str(i)+str(j)+str(k)):
                    cnt += 1
    return cnt


if __name__ == '__main__':
    n = int(input())
    print(solution(n))
