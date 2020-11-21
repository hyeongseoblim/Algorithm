import math
if __name__ == '__main__':
    n = int(input())
    m = int(input())

    start = math.floor(math.sqrt(n))
    end = math.floor(math.sqrt(m))+1
    res = 0
    for i in range(start,end):
        if math.pow(i,2)<n or math.pow(i,2)>m:
            continue
        else:
            res+=math.pow(i,2)

    if res > 0:
        print(int(res))
        if math.pow(start, 2) < n:
            print(int(math.pow(start+1,2)))
        else:
            print(int(math.pow(start,2)))

    else:
        print(-1)