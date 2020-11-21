def solution(m,k):
    answer = ''
    m = list(m)
    idx =0
    for i in k:
        for j in range(idx,len(m)):
            if i == m[j]:
                m[j]=''
                idx = j
                break
    return ''.join(m)


if __name__ == '__main__':
    print(solution("kkaxbycyz","abc"))
    print(solution("acbbcdc","abc"))