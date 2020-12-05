package BAEK;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1726 {
    static int N, M;
    static int[][] map = new int[101][101];
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static boolean[][][] visit = new boolean[101][101][5];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int sty = Integer.parseInt(st.nextToken());
        int stx = Integer.parseInt(st.nextToken());
        int std = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int dey = Integer.parseInt(st.nextToken());
        int dex = Integer.parseInt(st.nextToken());
        int ded = Integer.parseInt(st.nextToken());
        visit[sty][stx][std] = true;
        bfs(new int[]{sty, stx, std, 0}, new int[]{dey, dex, ded});

    }

    static boolean check(int y, int x) {
        if (y <= M && x <= N && x > 0 && y > 0)
            return true;
        else
            return false;
    }

    static void bfs(int[] start, int[] end) {

        Queue<int[]> que = new LinkedList<>();
        que.add(start);

        while (!que.isEmpty()) {
            int[] now = que.poll();

            int cy = now[0];
            int cx = now[1];
            int dir = now[2];
            int cnt = now[3];

            if (cy == end[0] && cx == end[1] && dir == end[2]) {
                System.out.println(cnt);
            }

            for (int j = 1; j <= 3; j++) {
                int ny = cy + (dy[dir - 1] * j);
                int nx = cx + (dx[dir - 1] * j);
                if (check(ny, nx)) {
                    if (map[ny][nx] == 0) {
                        if (!visit[ny][nx][dir]) {
                            visit[ny][nx][dir] = true;
                            que.add(new int[]{ny, nx, dir, cnt + 1});
                        }
                    } else
                        break;
                }
            }

            for (int j = 1; j <= 4; j++) {
                int val = 1;
                if (dir != j && !visit[cy][cx][j]) {
                    if (dir == 1) {
                        if (j == 2) ++val;
                    } else if (dir == 2) {
                        if (j == 1) ++val;
                    } else if (dir == 3) {
                        if (j == 4) ++val;
                    } else {
                        if (j == 3) ++val;
                    }
                    visit[cy][cx][j] = true;
                    que.add(new int[]{cy, cx, j, cnt + val});
                }
            }

        }

    }
}
