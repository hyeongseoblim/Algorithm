def solution(N):
    arr =[0]* 50
    arr[0] = 0;
    arr[1] = 1;
    arr[2] = 2;
    for  i in range(3,N+1) :
        arr[i] = arr[i - 1] + arr[i - 2];
    return arr[N]

if __name__ == '__main__':
    print(solution(1))
    print(solution(2))
    print(solution(3))
    print(solution(4))