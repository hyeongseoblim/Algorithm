import collections

def dfs(adj,v,visit):
    visit[v]=True
    print(v, end=' ')
    for i in adj[v]:
        if not visit[i]:
            dfs(adj,i,visit)

def bfs(adj, start, visit):
    que = collections.deque([start])
    visit[start]=True
    while(len(que)>0):
        v = que.popleft()
        print(v,end=' ')
        for i in adj[v]:
            if not visit[i]:
               visit[i]=True
               que.append(i)


if __name__ == '__main__':
    adj_graph = [[],[2,3,8],[1,7],[1,4,5],[3,5],[3,4],[7],[2,6,8],[1,7]]
    visited_dfs = [False]*9
    visited_bfs = [False]*9
    dfs(adj_graph,1,visited_dfs)
    print("\n")
    bfs(adj_graph,1,visited_bfs)




# 1 1 2
# 1 1 3
# 1 1 8
# 2 2 1
# 2 2 7
# 3 3 1
# 3 3 4
# 3 3 5
# 4 4 3
# 4 4 5
# 5 5 3
# 5 5 4
# 6 6 7
# 7 7 2
# 7 7 6
# 7 7 8
# 8 8 1
# 8 8 7