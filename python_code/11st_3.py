import random
def solution(A):
    line = [False]*(len(A)+1)
    no = list()
    for i in A:
        if not line[i]:
            line[i] = True
        else:
            no.append(i)
    com =list()
    for j in range(1,len(line)):
        if not line[j]:
            com.append(j)
    com.sort()
    no.sort()
    res = 0
    for i in range(len(no)):
        res += abs(no[i]-com[i])
    print(res)
    return res


if __name__ == '__main__':
    # solution([6,2,3,5,6,3])
    # solution([2,1,4,4])
    solution([20, 15, 16, 20, 20, 7, 11, 3, 7, 20, 7, 5, 15, 18, 12, 13, 15, 13, 14, 9])
    rand = [0]*20
    for i in range (len(rand)):
        rand[i] = random.randint(1,20)
    print(rand)
    solution(rand)