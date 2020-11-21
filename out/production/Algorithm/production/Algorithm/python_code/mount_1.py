notation = '0123456789ABCDEF'
def three(number, divnum):
    q, r= divmod(number,divnum)
    n = notation[r]
    return three(q,divnum)+ n if q else n

def solution(n):
    threerev = three(n,3)
    answer =0
    if threerev[0] == '1':
        answer = threerev[0]
    print(threerev)
    mul = 3
    for i in range(1,len(threerev)):
        if threerev[i] != 0:
            answer+=(mul*int(threerev[i]))
        mul*=3

    return answer

print(solution(6))