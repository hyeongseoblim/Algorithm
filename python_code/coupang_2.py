def change(line):

    temp = line.split(":")
    start = int(temp[0]) * 3600 + int(temp[1]) * 60 + int(temp[2])

    return start

def solution(n, customers):
    answer =0
    kio = [[0]*5 for _ in range(n)]
    for i in range(n):
        kio[i][0] = i+1
    line = customers[0].split()
    start = change(line[1])
    kio[0][1]=1
    kio[0][2] =int(line[2])*60
    kio[0][4] +=1

    for i in range(1,len(customers)):
        line = customers[i].split()
        cnt = 0
        now = change(line[1])
        flag = True
        for j in range(len(kio)):
            if kio[j][1] == 0 and flag:
                kio[j][1] = 1
                kio[j][2] = int(line[2])*60
                kio[j][3] = 0
                kio[j][4] += 1
                flag = False
            else:
                if kio[j][1] == 0:
                    kio[j][3]-= (now-start)
                else:
                    kio[j][2] -= (now - start)
                cnt+=1
        start = now
        if cnt == n:
            min = [100000000,0]
            for k in kio:
                if k[2]<min[0]:
                    min[0] = k[2]
                    min[1] = k[0]
            for l in kio:
                l[2] -=min[0]
            kio[min[1]-1][2]=int(line[2])*60
            kio[min[1]-1][4] +=1

    for maxval in kio:
        print(maxval)
        if maxval[4]>answer:
            answer=maxval[4]

    print(answer)
    return answer

solution(3,["10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"])
solution(2,	["02/28 23:59:00 03","03/01 00:00:00 02", "03/01 00:05:00 01"])