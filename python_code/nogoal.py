def solution(participant, completion):
    answer = ''
    participant.sort()
    completion.sort()
    for i in range(len(participant)):
        try:
            if(participant[i]!=completion[i]):
                answer = participant[i]
                break
        except:
            answer = participant[-1]
    return answer

if __name__ == '__main__':
    p = ["mislav", "stanko", "mislav", "ana"]
    c= ["stanko", "ana", "mislav"]
    print(solution(p,c))