import json

if __name__ == '__main__':

    try:
        with open("camping_1_450.json", encoding="utf-8") as f:
            data = json.loads(f.read())
    except FileNotFoundError as e:
        print(f"`{data_path}` 가 존재하지 않습니다.")
        exit(1)
    try:
        with open("camping_451_900.json", encoding="utf-8") as f2:
            data2 = json.loads(f2.read())
    except FileNotFoundError as e:
        print(f"`{data_path}` 가 존재하지 않습니다.")
        exit(1)
    try:
        with open("camping_901_1350.json", encoding="utf-8") as f3:
            data3 = json.loads(f3.read())
    except FileNotFoundError as e:
        print(f"`{data_path}` 가 존재하지 않습니다.")
        exit(1)

    try:
        with open("camping_1351_1800.json", encoding="utf-8") as f8:
            data8 = json.loads(f8.read())
    except FileNotFoundError as e:
        print(f"`{data_path}` 가 존재하지 않습니다.")
        exit(1)
    try:
        with open("camping_1801_finish.json", encoding="utf-8") as f9:
            data9 = json.loads(f9.read())
    except FileNotFoundError as e:
        print(f"`{data_path}` 가 존재하지 않습니다.")
        exit(1)

    reviews = list()
    idx =1
    for i in data:
        i["id"]=idx
        reviews.append(i)
        idx+=1

    for j in data2:
        j["id"]=idx
        reviews.append(j)
        idx+=1

    for j in data3:
        j["id"]=idx
        reviews.append(j)
        idx+=1
    for j in data8:
        j["id"] = idx
        reviews.append(j)
        idx += 1

    for j in data9:
        j["id"]=idx
        reviews.append(j)
        idx+=1

    with open("camp2.json", "w",encoding="utf-8") as wf:
        wf.write(json.dumps(reviews,ensure_ascii=False))

