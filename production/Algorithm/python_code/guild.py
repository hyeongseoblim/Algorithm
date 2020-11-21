
if __name__ == '__main__':
    n = int(input())
    line = list(map(int,input().split()))

    line.sort()
    cnt =0
    e = len(line)
    idx =0
    while e>0:
        horr = line[idx]
        idx += horr
        e-=horr
        if e>=0:
            cnt+=1
    print(cnt)