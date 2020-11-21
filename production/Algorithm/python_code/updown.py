num = int(input())

arr = list()
for i in range(num):
    arr.append(int(input()))
arr = sorted(arr,reverse=True)
print(arr)
