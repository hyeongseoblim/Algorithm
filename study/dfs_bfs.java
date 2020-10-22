import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dfs_bfs {
    static int[][] map;
    static boolean[] DFSvisited;
    static boolean[] BFSvisited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        DFSvisited = new boolean[N + 1];
        BFSvisited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
            map[x][y] = 1;
        }
        dfs(start);
        bfs(start);
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        BFSvisited[start] = true;
        System.out.println(start);
        while (!que.isEmpty()) {
            int now = que.poll();
            for (int i = 0; i < map[now].length; i++) {
                if (!BFSvisited[i]&&map[now][i] != 0) {
                    BFSvisited[i]=true;
                    que.offer(i);
                    System.out.println(i);
                }
            }
        }

    }

    private static void dfs(int now) {
        System.out.print(now + " ");
        DFSvisited[now] = true;
        for (int i = 1; i < N + 1; i++) {
            if (check(now) && !DFSvisited[i] && map[now][i] == 1) {
                DFSvisited[i] = true;
                dfs(i);
            }
        }
    }

    private static boolean check(int y) {
        if (y > N || y < 0)
            return false;
        return true;
    }
}
