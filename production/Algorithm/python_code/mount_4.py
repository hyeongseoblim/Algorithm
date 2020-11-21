def solution(s):
    answer = 0
    for i in range(len(s)):
        res =0
        for j in range(i+1,len(s)):

            if s[i] != s[j]:
                res = max(res,j-i)
            print(s[i:j + 1])
            answer+=res
    return answer


print(solution("abbca"))