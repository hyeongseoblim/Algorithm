package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500 {
    static int N, M;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                max = Math.max(max, dfs(1, new int[]{i, j}, map[i][j]));
                visit[i][j] = false;
                max = Math.max(max,dfs2(new int[]{i,j}));
            }
        }
        System.out.println(max);
    }

    private static boolean check(int y, int x) {
        if (y < 0 || x < 0 || x >= M || y >= N)
            return false;
        return true;
    }

    private static int dfs(int depth, int[] now, int val) {
        int y = now[0];
        int x = now[1];
        if (depth == 4) {
            return val;
        }
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (check(ny, nx) && !visit[ny][nx]) {
                visit[ny][nx] = true;
                cnt = Math.max(dfs(depth + 1, new int[]{ny, nx}, val + map[ny][nx]), cnt);
                visit[ny][nx] = false;
            }
        }
        return cnt;
    }

    private static int dfs2(int[] now) {
        int y = now[0];
        int x = now[1];
        int val = map[y][x];
        // 한방향씩 뺴놓고 3개씩 ㅓ ㅏ ㅗ ㅜ
        int cnt = 0;
        if (check(y + dy[0], x + dx[0]) && check(y + dy[1], x + dx[1]) && check(y + dy[2], x + dx[2])) {
            cnt = Math.max(cnt, val + (map[y + dy[0]][x + dx[0]] + map[y + dy[1]][x + dx[1]] + map[y + dy[2]][x + dx[2]]));
        }
        if (check(y + dy[0], x + dx[0]) && check(y + dy[1], x + dx[1]) && check(y + dy[3], x + dx[3])) {
            cnt = Math.max(cnt, val + (map[y + dy[0]][x + dx[0]] + map[y + dy[1]][x + dx[1]] + map[y + dy[3]][x + dx[3]]));
        }
        if (check(y + dy[0], x + dx[0]) && check(y + dy[2], x + dx[2]) && check(y + dy[3], x + dx[3])) {
            cnt = Math.max(cnt, val + (map[y + dy[0]][x + dx[0]] + map[y + dy[2]][x + dx[2]] + map[y + dy[3]][x + dx[3]]));
        }
        if (check(y + dy[1], x + dx[1]) && check(y + dy[2], x + dx[2]) && check(y + dy[3], x + dx[3])) {
            cnt = Math.max(cnt, val + (map[y + dy[1]][x + dx[1]] + map[y + dy[2]][x + dx[2]] + map[y + dy[3]][x + dx[3]]));
        }
        return cnt;
    }
}
