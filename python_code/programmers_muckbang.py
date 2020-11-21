import heapq

def solution(food_times, k):
    answer = 0
    total = sum(food_times)
    if total<=k:
        return -1

    queue = list()
    for i in range(len(food_times)):
      heapq.heappush(queue,(food_times[i],i+1))
    sumv = 0
    prev = 0
    leng = len(food_times)
    while sumv +((queue[0][0]-prev)*leng) <=k:
        now = heapq.heappop(queue)[0]
        sumv += (now-prev)*leng
        leng-=1
        prev = now

    answer = sorted(queue,key = lambda x: x[1])

    return answer[(k-sumv)%leng][1]


if __name__ == '__main__':
    print(solution([3, 1, 2],5))
    print(solution([4,2,3,6,7,1,5,8],27))
    print(solution([4,2,3,6,7,1,5,8],16))
    print(solution([1,1,1,1],4))