from itertools import combinations
from collections import Counter


def solution(orders, course):
    answer = []
    cnt_list = list([] for _ in range(11))
    for menus in orders:
        for count in course:
            course_menu = list(combinations(menus, count))
            cnt_list[count].extend(course_menu)
    res = list()
    for i in cnt_list:
        if len(i) > 0:
            for j in range(len(i)):
                i[j]= list(i[j])
                i[j].sort()
                i[j]=tuple(i[j])
            cn_dict = Counter(i)
            cn_dict = dict(cn_dict)
            max_value = Counter(i).most_common(1)
            max_value = max_value[0][1]
            if max_value >= 2:
                for j in cn_dict.items():
                    if j[1] == max_value:
                        answer.append(''.join(j[0]))

    answer.sort()

    return answer


if __name__ == '__main__':
    print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2, 3, 4]))
    # print(solution(["XYZ", "XWY", "WXA"],[2,3,4]))