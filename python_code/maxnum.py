def solution(numbers):
    answer = ''
    for i in range(len(numbers)):
        numbers[i]=str(numbers[i])*3
    numbers.sort(reverse=True)
    sumlist = list()
    for i in range(len(numbers)):
        numbers[i]=numbers[i][0:len(numbers[i])//3]
    answer=''.join(numbers)
    return answer

solution([3, 30, 34, 5, 9])