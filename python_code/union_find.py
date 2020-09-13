#특정 원소가 포함된 집합 찾기
def find_parent(parent, x):
    # 루트 노드가 아니라면, 루트 노드를 찾을 때 까지 재귀적으로 호출한다.
    if parent[x] != x: #루트까지 계속 거슬러 올라가는 재귀 호출
        return find_parent(parent,parent[x]) # x가 자기 자신을 가리킬때 루트임 -> 처음 입력 받은 x라는 보장은 아님
    return x

# 두 원소가 속한 집합을 합치기
def union_parent(parent,a,b):
    a = find_parent(parent,a)
    b = find_parent(parent,b)

    if a<b:
        parent[b]=a
    else:
        parent[a]=b

if __name__ == '__main__':
    v, e  =map(int, input().split())
    parent = [0]*(v+1) #부모 테이블 초기화


    #부모테이블에서 자기 자신으로 초기화
    for i in range(1,len(parent)):
        parent[i]=i
    #union 연산 각각 수행
    for i in range(e):
        a,b = map(int,input().split())
        union_parent(parent,a,b)
    for i in range(1,v+1):
        print(find_parent(parent,i),end=' ')
    print()
    for i in range(1, v + 1):
        print(parent[i], end=' ')
