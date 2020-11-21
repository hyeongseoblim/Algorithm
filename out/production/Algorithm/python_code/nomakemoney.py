from itertools import combinations
if __name__ == '__main__':
    n = int(input())
    coins = list(map(int,input().split()))
    coins.sort()
    result = [0]*1000000
    for i in range(1,len(coins)+1):
        a = list(combinations(coins,i))
        for k in a:
            result[sum(k)]=1

    for j in range(1,len(result)):
        if result[j] == 0:
            print(j)
            break