def solution(phone_book):
    phone_book = sorted(phone_book)
    answer = True
    for i in range(len(phone_book)):
        j = i+1
        while j!=len(phone_book):
            pre = len(phone_book[i])
            if phone_book[j][0:pre] == phone_book[i]:
                return False
            j+=1

    return answer


