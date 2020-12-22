package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class dijkstarAlgorithm {
    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance < o.distance)
                return -1;
            return 1;
        }
    }

    static final int INF = (int) 1e9;
    static int n, m, start;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] dist = new int[100001];

    private static void dijkstra(int start) {
        //시작 노드로 가기 위한 최단 경로는 0, 큐에 삽입.
//        PriorityQueue<Node> pq = new PriorityQueue<>();
//        pq.offer(new Node(start, 0));
//        dist[start] = 0;
//        // 큐가 비어 있지 않는 동안 가장 최단 거리가 짧은 노드에 대해 정보 꺼내기
//
//        while (!pq.isEmpty()) {
//            Node now = pq.poll();
//            int dis = now.getDistance();
//            int idx = now.getDistance();
//            if (dist[idx] < dis)
//                continue;
//            for (int i = 0; i < graph.get(idx).size(); i++) {
//                int cost = dist[idx] + graph.get(idx).get(i).getDistance();
//                if (cost < dist[graph.get(idx).get(i).getIndex()]) {
//                    dist[graph.get(idx).get(i).getIndex()] = cost;
//                    pq.offer(new Node(graph.get(idx).get(i).getIndex(), cost));
//                }
//            }
//        }
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(start,0));
        dist[start] =0;
        while(!que.isEmpty()){
            Node now = que.poll();
            int distance = now.distance;
            int idx = now.index;
            if(dist[idx]<distance)
                continue;
            for (int i = 0; i < graph.get(idx).size(); i++) {
                int cost = dist[idx]+graph.get(idx).get(i).distance;
                if(cost<dist[graph.get(idx).get(i).index]){
                    dist[graph.get(idx).get(i).index]=cost;
                    que.add(new Node(graph.get(idx).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }
        Arrays.fill(dist, INF);

        dijkstra(start);

        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF)
                System.out.println("INFINITY");
            else
                System.out.println(dist[i]);
        }
    }
}
