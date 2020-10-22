import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class algoproblem {
    static int[] parent;

    static class point {
        int a;
        int b;
        int cost;

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int getCost() {
            return cost;
        }

        public point(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[100001];
        for (int i = 1; i <=n; i++) {
            parent[i] = i;
        }
        ArrayList<point> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new point(a, b, cost));
        }
        Collections.sort(edges, new Comparator<point>() {
            @Override
            public int compare(point o1, point o2) {
                if (o1.cost < o2.cost) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        int result = 0;
        int last = 0;
        for (point edge : edges) {
            if (find(edge.a) != find(edge.b)) {
                union(edge.a, edge.b);
                result += edge.cost;
                last = edge.cost;
            }
        }
        sb.append(String.valueOf(result - last));
        System.out.println(sb.toString());

    }


    private static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x]=find(parent[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b)
            parent[a] = b;
        else
            parent[b] = a;
    }
}
