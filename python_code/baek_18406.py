if __name__ == '__main__':
    number = input()
    mid = len(number)//2

    first = number[0:mid]
    second = number[mid:]

    first_result =0
    second_result=0
    for i in first:
        first_result += int(i)
    for j in second:
        second_result += int(j)

    if first_result == second_result:
        print("LUCKY")
    else:
        print("READY")