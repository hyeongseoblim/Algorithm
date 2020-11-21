num = int(input())

student = dict()

for i in range(num):
    name, score = input().split()
    student[name]=int(score)

student = sorted(student)

print(student)