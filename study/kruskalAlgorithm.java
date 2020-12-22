package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class kruskalAlgorithm {
    static int[] parent;
    static ArrayList<Node> edges;
    static int v, e;

    static class Node implements Comparable<Node> {
        private int distance;
        private int start;
        private int end;

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public Node(int distance, int start, int end) {
            this.distance = distance;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (this.getDistance() < o.getDistance())
                return -1;
            return 1;
        }
    }

    public static int find(int now) {
        if (parent[now] == now)
            return now;
        else
            return parent[now] = find(parent[now]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        parent = new int[v + 1];
        edges = new ArrayList<>();
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Node(cost, a, b));
        }
        Collections.sort(edges);
        int result = 0;
        for (Node e : edges) {
            if (find(e.getStart()) != find(e.getEnd())) {
                union(e.getStart(), e.getEnd());
                result += e.getDistance();
            }
        }
        System.out.println(result);
    }
}
