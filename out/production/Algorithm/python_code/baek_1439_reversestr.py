if __name__ == '__main__':
    line = input()

    isZero = 0
    isOne = 0

    cnt = 0

    start = line[0]
    if start == '0':
        isOne+=1
    else:
        isZero+=1

    for i in range(len(line)-1):
        if line[i] != line[i+1]:
            if line[i+1] == '1':
                isZero+=1
            else:
                isOne+=1
    print(min(isOne,isZero))




