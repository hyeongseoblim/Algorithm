def solution(info, query):
    answer = []
    info_list= list()
    for i in info:
        info_list.append(i.split())

    query_list =list()
    for j in query:
        query_list.append(list(j.replace("and","").split()))

    for k in query_list:
        chk=0
        for l in info_list:
            cnt =0
            if k[0]=='-' or k[0] == l[0]:
                cnt+=1
            if k[1] == '-' or k[1] == l[1]:
                cnt+=1
            if k[2] == '-' or k[2] == l[2]:
                cnt+=1
            if k[3] == '-' or k[3] == l[3]:
                cnt+=1
            if int(k[4])<=int(l[4]):
                cnt+=1
            if cnt == 5:
                chk+=1
        answer.append(chk)
    return answer


if __name__ == '__main__':
     print(solution(["java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"],
                    ["java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"]))