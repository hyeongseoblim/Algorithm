def solution(blocks):
    answer = []

    pyr = [[] for _ in range(len(blocks))]
    visit = [[] for _ in range(len(blocks))]
    for i in range(len(blocks)):
        for j in range(i + 1):
            pyr[i].append(0)
            visit[i].append(False)
        pyr[i][blocks[i][0]] = blocks[i][1]
        visit[i][blocks[i][0]] = True

    for stair in range(1, len(pyr)):
        check = False
        while not check:
            cnt = 0
            for line in range(len(pyr[stair])):
                if not visit[stair][line]:
                    if not visit[stair][line + 1]:
                        continue
                    else:
                        temp = pyr[stair - 1][line] - pyr[stair][line + 1]
                        visit[stair][line] = True
                        pyr[stair][line] = temp
                else:
                    cnt += 1
                    if line == len(pyr[stair]) - 1:
                        continue
                    else:
                        if not visit[stair][line + 1]:
                            visit[stair][line + 1] = True
                            pyr[stair][line + 1] = pyr[stair - 1][line] - pyr[stair][line]

            if cnt == len(pyr[stair]):
                break
    for i in range(len(pyr)):
        for j in range(len(pyr[i])):
            answer.append(pyr[i][j])

    return answer


if __name__ == '__main__':
    print(solution([[0, 50], [0, 22], [2, 10], [1, 4], [4, -13]]))
    print(solution([[0, 92], [1, 20], [2, 11], [1, -81], [3, 98]]))
