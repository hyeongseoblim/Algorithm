def preorder(node,graph, cnt):
    if node == None:
        return
    for k in range(len(graph[node])):
        cnt = preorder(graph[node][k],graph,cnt+1)
    return cnt


def solution(n, edges):
    answer = n

    graph = [[] for _ in range(19)]

    for i in edges:
        graph[i[0]].append(i[1])

    temp = list()
    for i in range(len(graph)):
        for k in range(len(graph[i])):
            temp.append((preorder(graph[i][k],graph,1),k))
        print(temp)
        temp.sort()
        answer -= temp[-1][1]
        graph[i].remove(graph[i][temp[-1][1]])
    return answer


if __name__ == '__main__':
    print(solution(19,
                   [[0, 1], [0, 2], [0, 3], [1, 4], [1, 5], [2, 6], [3, 7], [3, 8], [3, 9], [4, 10], [4, 11], [5, 12],
                    [5, 13], [6, 14], [6, 15], [6, 16], [8, 17], [8, 18]]))
