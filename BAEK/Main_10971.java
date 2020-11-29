package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_10971 {
    static int[][] map;
    static boolean[] visit;
    static int n;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int[] next = new int[n];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            dfs(0, arr, next);
        }


        System.out.println(min);
    }

    private static void dfs(int depth, int[] arr, int[] next) {
        if (depth == n) {

            int now = 0;
            int cnt = 0;
            for (int j = 0; j < next.length - 1; j++) {
                int val = map[next[j]][next[j + 1]];
                if (val == 0)
                    continue;
                now += val;
                cnt++;
            }
            int last = map[next[n - 1]][next[0]];
            if (last != 0 && cnt == n - 1) {
                now += last;
                min = Math.min(now, min);
            }
            return;
        }
        for (int i = 0; i < visit.length; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            next[depth] = arr[i];
            dfs(depth + 1, arr, next);
            visit[i] = false;
        }
    }
}
//0 10 15 20
//        5 0 9 0
//        6 13 0 12
//        8 8 9 0