def solution(s):
    n = len(s)
    m = len(s[0])

    line = [[0] * 27 for _ in range(m)]
    for i in range(len(s)):
        for j in range(len(s[i])):
            idx = ord(s[i][j])-97
            line[j][idx] += 1

    res_idx, res_val = 0,0
    check =False
    for i in range(m):
        if check:
            break
        for j in range(len(line[i])):
            if line[i][j] == 2:
                res_idx = i
                res_val = chr(j+97)
                check =True
                break
    ans =list()

    if check:
        for i in range(len(s)):
            if s[i][res_idx] == res_val:
                ans.append(i)
            if len(ans) == 2:
                break
        ans.append(res_idx)

    return ans

if __name__ == '__main__':
    print(solution(["zzzz", "ferz", "zdsr", "fgtd"]))
