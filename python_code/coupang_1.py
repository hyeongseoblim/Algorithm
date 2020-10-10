notation = '0123456789ABCDEF'
def jin(number, divnum):
    q, r= divmod(number,divnum)
    n = notation[r]
    return jin(q,divnum)+ n if q else n


notation = '0123456789ABCDEF'
def soltuion(N):
    answer = []
    ans =[1,1]
    for i in range(2,10):
        temp = list(map(int,jin(N,i)))[::-1]
        tempval = 1
        for j in temp:
            if j == 0:
                continue
            else:
                tempval*=j
        if tempval >= ans[0]:
            ans[0]=tempval
            ans[1]=i
    print(ans)
    return answer

if __name__ == '__main__':
    soltuion(100)