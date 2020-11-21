from collections import Counter
def solution(k,score):
    answer = -1
    now = score[0]
    sub = list()
    sub.append(0)

    for i in range(1,len(score)):
        sub.append(now-score[i])
        now= score[i]
    keys = list()
    temp = dict(Counter(sub))
    for i in temp:
        if temp[i] >= k:
            keys.append(i)
    flag = [False] * len(score)
    for i in range(len(sub)):
        for key in keys:
            if sub[i] == key:
                flag[i]=True
                if not flag[i-1]:
                    flag[i-1]=True
    answer = 0
    for count in flag:
        if not count:
            answer+=1
    print(answer)
    return answer

solution(3,[24,22,20,10,5,3,2,1])
solution(2,[1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100])