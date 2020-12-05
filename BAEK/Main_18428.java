package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18428 {
    static char[][] map;
    static ArrayList<int[]> teacher;
    static int N;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        teacher = new ArrayList<>();
        boolean[] space = new boolean[N * N];
        int std = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'T')
                    teacher.add(new int[]{i, j});
                if (map[i][j] == 'X')
                    space[i * N + j] = true;
            }
        }
        boolean flag = false;

        for (int i = 0; i < space.length; i++) {
            if (!space[i])
                continue;
            else {
                space[i] = true;
                flag = dfs(1, space,flag);
                space[i] = false;
            }
        }

        if (flag)
            System.out.println("NO");
        else
            System.out.println("YES");

    }

    static boolean check(int y, int x) {
        if (y < 0 || x < 0 || y >= N || x >= N)
            return false;
        return true;
    }

    static boolean watch(int y, int x, int dir) {
        for (int j = 1; j < N; j++) {
            int ny = y + dy[dir] * j;
            int nx = x + dx[dir] * j;
            if (check(ny, nx)) {
                if (map[ny][nx] == 'S')
                    return true;
                else if (map[ny][nx] == 'O')
                    return false;
            }
        }
        return false;
    }

    static boolean dfs(int cnt, boolean[] space, boolean flag) {
        if (cnt == 3) {
            boolean flag = true;
            for (int i = 0; i < teacher.size(); i++) {
                int[] now = teacher.get(i);
                flag = watch(now[0], now[1], 0);
                flag = watch(now[0], now[1], 1);
                flag = watch(now[0], now[1], 2);
                flag = watch(now[0], now[1], 3);
            }
            return flag;
        }

        for (int i = 0; i < space.length; i++) {
            if (!space[i])
                continue;
            else {
                space[i] = true;
                dfs(1, space);
                space[i] = false;
            }
        }

    }
}
