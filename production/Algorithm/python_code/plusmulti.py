from sys import stdin

if __name__ == '__main__':
    number = list(map(int,stdin.readline().rstrip()))

    result = number[0]

    for i in range(1,len(number)):
        if result == 0:
            result += number[i]
        else:
            result *= number[i]

    print(result)