n,k = map(int,input().split())

f_arr = list(map(int,input().split()))
s_arr = list(map(int,input().split()))

f_arr = sorted(f_arr)
s_arr = sorted(s_arr,reverse=True)

for i in range(k):
    if f_arr[i]<s_arr[i]:
        f_arr[i],s_arr[i]=s_arr[i],f_arr[i]
    else:
        cnt = i+1
        while f_arr[cnt]>s_arr[i]:
            cnt+=1
        f_arr[cnt],s_arr[i]=s_arr[i],f_arr[cnt]

print(sum(f_arr))
