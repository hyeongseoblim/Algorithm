package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import java.util.StringTokenizer;

public class Main_15686 {
    static ArrayList<boolean[]> possichk;

    static class point implements Comparable<point> {
        int num;
        int jiy;
        int jix;
        int chy;
        int chx;

        public point(int num, int jiy, int jix, int chy, int chx) {
            this.num = num;
            this.jiy = jiy;
            this.jix = jix;
            this.chy = chy;
            this.chx = chx;
        }

        @Override
        public int compareTo(point o) {
            if (this.num < o.num)
                return -1;
            else if (this.num == o.num)
                return 0;
            else
                return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        possichk = new ArrayList<>();
        ArrayList<int[]> house = new ArrayList<>();
        ArrayList<int[]> chicken = new ArrayList<>();
        int[][] map = new int[N][N];
        boolean[][] check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    house.add(new int[]{i, j});
                else if (map[i][j] == 2)
                    chicken.add(new int[]{i, j});
            }
        }

        int size = chicken.size();


        nCr(0, 0, new boolean[size], size, M);
        int result = Integer.MAX_VALUE;
        for (int k = 0; k < possichk.size(); k++) {
            ArrayList<point> list = new ArrayList<>();
            for (int i = 0; i < house.size(); i++) {
                for (int j = 0; j < chicken.size(); j++) {
                    if (!possichk.get(k)[j])
                        continue;
                    int score = Math.abs(house.get(i)[0] - chicken.get(j)[0]) + Math.abs(house.get(i)[1] - chicken.get(j)[1]);
                    point temp = new point(score, house.get(i)[0], house.get(i)[1], chicken.get(j)[0], chicken.get(j)[1]);
                    list.add(temp);
                }
            }
            Collections.sort(list);
            result = Math.min(result, find(map, list, new boolean[N][N]));
        }

        System.out.println(result);

    }

    public static int find(int[][] map, ArrayList<point> list, boolean[][] check) {
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            point now = list.get(i);
            if (check[now.jiy][now.jix])
                continue;
            result += now.num;
            check[now.jiy][now.jix] = true;
        }
        return result;
    }

    public static void nCr(int start, int count, boolean[] c, int N, int R) {
        if (count == R) {
            boolean[] temp = c.clone();
            possichk.add(temp);
            return;
        }
        for (int i = start; i < N; i++) {
            if (!c[i]) {
                c[i] = true;
                nCr(i + 1, count + 1, c, N, R);
                c[i] = false;
                ;
            }
        }
    }
}
