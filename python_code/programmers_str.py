def solution(s):
    answer = len(s)
    start = 1
    end = len(s) // 2 + 1

    for i in range(start, end):
        cnt = 1
        prev = s[0:i]
        result = ""
        for j in range(i, len(s), i):
            if prev == s[j:j + i]:
                cnt += 1
            else:
                if cnt >= 2:
                    result += str(cnt) + prev
                else:
                    result += prev
                prev = s[j:j + i]
                cnt = 1
        if cnt >= 2:
            result += str(cnt) + prev
        else:
            result += prev

        answer = min(answer, len(result))

    return answer


if __name__ == '__main__':
    print(solution("aabbaccc"))
    print(solution("ababcdcdababcdcd"))
    print(solution("abcabcabcabcdededededede"))
    print(solution("xababcdcdababcdcd"))
