fcnt=0
scnt=0

def fi(depar,hub, edge,flag):
    global fcnt
    if depar == hub:
        fcnt+=1
        return
    for i in edge[depar]:
        if flag[i]:
            continue
        flag[i]=True
        fi(i,hub,edge,flag)
        flag[i]=False
def ne (hub,dest,edge,flag):
    global scnt
    if hub == dest:
        scnt+=1
        return
    for i in edge[hub]:
        if flag[i]:
            continue
        flag[i] = True
        ne(i,dest,edge,flag)
        flag[i] = False

def solution(depar, hub, dest, roads):
    global fcnt,scnt
    answer =''
    idx = 0
    maps = dict()
    maps[depar] = idx
    idx+=1
    maps[hub] = idx
    idx+=1
    maps[dest] = idx
    for i in roads:
        for j in i:
            if j not in maps:
                idx+=1
                maps[j]=idx
    edge = [[] for _ in range(idx+1)]
    for i in roads:
        x = maps[i[0]]
        y = maps[i[1]]
        edge[x].append(y)
    flag = [False]*(idx+1)
    print(edge)
    x = maps[depar]
    y = maps[hub]
    z = maps[dest]

    flag[x]=True
    fi(x,y,edge,flag)
    flag[x]=False
    flag[y]=True
    ne(y,z,edge,flag)
    flag[y]=False

    answer = (fcnt*scnt)%100007
    print(answer)
    return answer

solution("SEOUL","DAEGU","YEOSU",[["ULSAN","BUSAN"],["DAEJEON","ULSAN"],["DAEJEON","GWANGJU"],["SEOUL","DAEJEON"],["SEOUL","ULSAN"],["DAEJEON","DAEGU"],["GWANGJU","BUSAN"],["DAEGU","GWANGJU"],["DAEGU","BUSAN"],["ULSAN","DAEGU"],["GWANGJU","YEOSU"],["BUSAN","YEOSU"]])