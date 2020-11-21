def multi(a,b,c):
    if b == 0:
        return 1
    if b == 1:
        return a%c

    val = multi(a,b//2,c)
    val = val*val%c
    if b%2 ==0 :
        return val
    return val*a%c

if __name__ == '__main__':
    a,b,c = map(int, input().split())
    print(multi(a,b,c))
