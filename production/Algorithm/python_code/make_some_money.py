from sys import stdin


def solution(arr, target):
    arr.sort()
    if target < arr[0]:
        return -1
    dp = [10001]*10000
    dp [0] =0
    for i in range(len(arr)):
        for j in range(arr[i],target+1):
            if dp[j-arr[i]] != 10001:
                dp[j]=min(dp[j-arr[i]]+1,dp[j])



    if dp[target-1] == 10001:
        return -1
    else:
        return dp[target]


    return


if __name__ == '__main__':
    n, m = map(int, stdin.readline().split())
    arr = list()
    for i in range(n):
        arr.append(int(stdin.readline().rstrip()))

    print(solution(arr,m))