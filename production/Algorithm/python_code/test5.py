from itertools import combinations_with_replacement
def solution(n, money):
    answer = 0
    ans = list()
    for i in range(n+1):
        temp = list(combinations_with_replacement(money,i))
        for j in temp:
            if sum(j) == n:
                answer+=1

    return answer%1000000007


solution(5,[1,2,5])