def solution(citations):
    answer = 0
    citations.sort(reverse=True)
    for i in range(len(citations)):
        cnt = 0
        for j in range(len(citations)):
            if i+1<=citations[j]:
                cnt +=1
            if cnt >= i+1:
                answer=max(answer,i+1)
    return answer


solution([3, 0, 6, 1, 5])
solution([12, 11, 10, 9, 8, 1])
solution([6, 6, 6, 6, 6, 1])
solution([4, 4, 4])
# [12, 11, 10, 9, 8, 1] 5
# [6, 6, 6, 6, 6, 1] 5
# [4, 4, 4] 3
# [4, 4, 4, 5, 0, 1, 2, 3] 4
# [10, 11, 12, 13] 4
# [3, 0, 6, 1, 5] 3
# [0, 0, 1, 1] 1
# [0, 1] 1
# [10, 9, 4, 1, 1] 3
