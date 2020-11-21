import sys

if __name__ == '__main__':
    input = list(sys.stdin.readline().rstrip())

    input.sort()
    idx = 0
    result = 0
    number = ['0','1','2','3','4','5','6','7','8','9']
    for i in range(len(input)):
        if input[i] in number:
            result += int(input[i])
        else:
            idx =i
            break

    input = input[i:]
    print(''.join(input)+str(result))