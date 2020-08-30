import itertools
from functools import reduce

def factorial(n):
    return reduce(lambda x, y: x * y, range(1, n+1))

def solution(num, cards):

    dp = [0 for i in range(10001)]

    dp[0] = 1
    for i in cards:
        for j in range(i, num + 1):
            dp[j] += dp[j - i]

    return dp[num]

if __name__ == '__main__':
    print(solution(8,[1,4,6]))