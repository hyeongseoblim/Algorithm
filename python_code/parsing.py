import json
import mysql.connector
import csv
import os

if __name__ == '__main__':
    config = {
        "user": "root",
        "password": "ssafy",
        "host": "j3b204.p.ssafy.io",  # local
        "database": "bigdata",  # Database name
        "port": "3306"}

    try:
        with open("camping33.json", encoding="utf-8") as f:
            data = json.loads(f.read())
    except FileNotFoundError as e:
        print(f"`{data_path}` 가 존재하지 않습니다.")
        exit(1)

    # 리뷰 테이블
    tags = []
    conn = mysql.connector.connect(**config)
    path = 'C:/Users/multicampus/pictures/temp'
    files = os.listdir(path)
    cursor = conn.cursor()

    for i in files:
        id = i.split("_")[0]
        url = i
        sql = "insert into `imagestore` (`campid`,`imgurl`) values(%s, %s)"
        temp = [id,url]
        cursor.execute(sql,temp)
        conn.commit()
    # for i in data:
    #     print(i)
    #     sql= "insert into `dining_area` (`area`) values( %s )"
    #     temp =[i]
    #     cursor.execute(sql,temp)
    #     conn.commit()
    #     for j in data.get(i):
    #         sql = "insert into `dining_latlng` (`store`,`lat`,`lng`,`area`) values(%s, %s, %s, %s)"
    #         temp = [j["store_name"],j["lat"],j["lng"],i]
    #         cursor.execute(sql,temp)
    #         conn.commit()
    # cursor.execute(sql)
    # f = cursor.fetchall()
    # print(f)
    # 없으면 None
    # tag_list= list()
    # for i in f:
    #     sql = "Delete from tag_camp where tag_id =(%s)"
    #     cursor.execute(sql,[i[0]])
    #     conn.commit()
    idx = 1
    # for d in data:
    #     sql = "UPDATE camp SET `campingName` =(%s) ,`campingType` = (%s) ,`commonCamp` =(%s),`carcamp` = (%s),`glamping` = (%s),`caraban` = (%s),`toilet` =(%s),`shower` = (%s),`wash` = (%s),`fire` = (%s),`address` = (%s),`lat` = (%s),`lng` = (%s) WHERE `id` = (%s)"
    #     # sql = "INSERT INTO `camp`( `campingName`,`campingType`, `commonCamp`,`carcamp`, `glamping`, `caraban`, `toilet`, `shower`, `wash`, `fire`, `tel`, `address`, `lat`, `lng`, `avgScore`,`url`)VALUES(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
    #     types = d["camping_type"].split(',')
    #     types.sort()
    #     camp_type = 0
    #     if len(types) == 1:
    #         if types[0] == '일반야영장':
    #             camp_type = 1
    #         elif types[0] == '자동차야영장':
    #             camp_type = 2
    #         elif types[0] == '카라반':
    #             camp_type = 3
    #         else:
    #             camp_type = 4
    #     elif len(types) == 2:
    #         if types[0] == '글램핑':
    #             if types[1] == '일반야영장':
    #                 camp_type = 5
    #             elif types[1] == '자동차야영장':
    #                 camp_type = 6
    #             elif types[1] == '카라반':
    #                 camp_type = 7
    #         elif types[0] == '일반야영장':
    #             if types[1] == '자동차야영장':
    #                 camp_type = 8
    #             elif types[1] == '카라반':
    #                 camp_type = 9
    #         elif types[0] == '자동차야영장':
    #             if types[1] == '카라반':
    #                 camp_type = 10
    #     elif len(types) == 3:
    #         if types[0] == '글램핑':
    #             if types[1] == '일반야영장':
    #                 if types[2] == '자동차야영장':
    #                     camp_type = 11
    #                 elif types[2] == '카라반':
    #                     camp_type = 12
    #             if types[1] == '자동차야영장':
    #                 if types[2] == '카라반':
    #                     camp_type = 13
    #         if types[0] == '일반야영장':
    #             if types[1] == '자동차야영장':
    #                 if types[2] == '카라반':
    #                     camp_type = 14
    #     else:
    #         camp_type = 15
    #     datas = (
    #         d["camping_name"],
    #         camp_type,
    #             d["common_camp"],
    #             d["car_camp"],
    #             d["glamping"],
    #             d["caraban"],
    #             d["toilet"],
    #             d["s_room"],
    #             d["w_room"],
    #             d["fire"],
    #             # d["tel"],
    #             d["address"],
    #             d["latitude"],
    #             d["longitude"],
    #             # d["avg_score"],
    #             # d["site_url"]
    #             d["id"]
    #     )
    #     cursor.execute(sql, datas)
    #     conn.commit()
        # utils = list(d["util"].replace(",","").split())
        # for idx2 in range(len(utils)):
        #     #있는지 검사.
        #     f= [utils[idx2]]
        #     sql = "select `id` from util where `type` = (%s)"
        #     cursor.execute(sql,f)
        #     a = cursor.fetchall()
        #     #없는 경우
        #     if len(a)==0:
        #         f= [f[0],1]
        #         sql4 = "insert into `util` (`type`,`cnt`) values (%s,%s)"
        #         cursor.execute(sql4,f)
        #         conn.commit()
        #         fj = [idx+idx2,idx]
        #     else:
        #         #있는 경우
        #         sql4 = "select `cnt` from util where `type` =(%s)"
        #         cursor.execute(sql4, f)
        #         ff = cursor.fetchall()
        #         sql4 = "update util set`cnt`= (%s) where `type` =(%s)"
        #         fa = int(ff[0][0]) + 1
        #         fasd = [str(fa), f[0]]
        #         cursor.execute(sql4, fasd)
        #         conn.commit()
        #         fj = [a[0][0],idx]
        #     sql4 ="insert into `util_camp`(`util_id`,`camp_id`) values(%s,%s)"
        #     cursor.execute(sql4,fj)
        #     conn.commit()
        #
        # for tag in range(len(d["tags"])):
        #     fe = [d["tags"][tag]]
        #     #잇는지 체크
        #     sql = "select `id` from tag where `tagName` = (%s)"
        #     cursor.execute(sql, fe)
        #     a = cursor.fetchall()
        #
        #     if len(a) == 0:
        #         sql3 = "insert into `tag`(tagName,cnt) values(%s,%s)"
        #         fe = [d["tags"][tag],1]
        #         cursor.execute(sql3, fe)
        #         conn.commit()
        #         f = [idx+tag,idx]
        #     else:
        #         sql3 = "select `cnt` from tag where `tagName` =(%s)"
        #         cursor.execute(sql3,fe)
        #         ff = cursor.fetchall()
        #         sql3 = "update tag set`cnt`= (%s) where `tagName` =(%s)"
        #         fa = int(ff[0][0])+1
        #         fas = [str(fa),fe[0]]
        #         cursor.execute(sql3,fas)
        #         conn.commit()
        #         f = [a[0][0], idx]
        #     sql3 =" insert into `tag_camp`(tag_id,camp_id) values(%s,%s)"
        #     cursor.execute(sql3,f)
        #     conn.commit()
        #
        # for review in d["reviews"]:
        #     sql2 = "insert into `review` (camp_id,userName,score,content,datetime) values(%s,%s,%s,%s,%s)"
        #     f = [idx,review["user_name"],review["score"],review["content"],review["date_time"]]
        #     cursor.execute(sql2,f)
        #     conn.commit()
        #
        # idx+=1
