from sys import stdout,stdin

def solution(n,arr):
    dp = [0]*n
    dp[0]=arr[0]
    dp[1]=max(arr[0],arr[1])
    for i in range(2,n):
        dp[i]=max(dp[i-1],dp[i-2]+arr[i])


    return dp[n-1]


if __name__ == '__main__':
    n = int(stdin.readline().rstrip())
    arr = list(map(int, stdin.readline().rstrip()))

    stdout.write(str(solution(n,arr)))
