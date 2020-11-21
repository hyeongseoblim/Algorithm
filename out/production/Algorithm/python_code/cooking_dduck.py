from sys import stdin, stdout


def binary_search(arr, target, start, end):
    if start > end:
        return -1

    mid = (start + end) // 2
    cutting = 0
    for i in arr:
        temp = i - mid
        if temp > 0:
            cutting += temp

    if cutting == target:
        return mid
    elif cutting < target:
        return binary_search(arr, target, start, mid - 1)
    else:
        return binary_search(arr, target, mid + 1, end)


def solution(arr, target):
    arr.sort()

    answer = binary_search(arr, target, 0, arr[len(arr)-1])

    return str(answer)


if __name__ == '__main__':
    n, m = map(int, stdin.readline().split())
    dduck = list(map(int, stdin.readline().split()))

    stdout.write(solution(dduck, m))
