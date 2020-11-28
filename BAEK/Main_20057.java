package BAEK;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20057 {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int total;
    static double[][] arr = {{0, 0, 0.02, 0, 0}, {0, 0.1, 0.07, 0.01, 0}, {0.05, 0.55, 0, 0, 0}, {0, 0.1, 0.07, 0.01, 0}, {0, 0, 0.02, 0, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        total = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int starty = N / 2;
        int startx = N / 2;
        dfs(starty, startx, 0, 0, 1, 0);
    }

    static boolean check(int y, int x) {
        if (y >= N || x >= N || y < 0 || x < 0)
            return false;
        return true;
    }

    static double[][] rotate(double[][] arr) {
        double[][] temp = new double[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                temp[j][5 - 1 - i] = arr[i][j];
            }
        }
        return temp;
    }

    static void windy(int y, int x, int dir) {

        int ny = y + dy[dir];
        int nx = x + dx[dir];
        int sty = ny - 2;
        int stx = nx - 2;

        if (dir == 0) {
            cal(sty, stx, arr, map[ny][nx]);
        } else if (dir == 1) {
            double[][] arr2 = rotate(arr);
            arr2 = rotate(arr2);
            arr2 = rotate(arr2);
            cal(sty, stx, arr2, map[ny][nx]);
        } else if (dir == 2) {
            double[][] arr2 = rotate(arr);
            arr2 = rotate(arr2);
            cal(sty, stx, arr2, map[ny][nx]);
        } else if (dir == 3) {
            double[][] arr2 = rotate(arr);
            cal(sty, stx, arr2, map[ny][nx]);
        }
        map[ny][nx] = 0;

    }

    static void cal(int y, int x, double[][] array, int val) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (check(y + i, x + j))
                    map[y + i][x + j] += (int) val * array[i][j];
                else {
                    total += (int) val * array[i][j];
                }
            }
        }
    }

    static void dfs(int y, int x, int cnt, int dir, int abs, int flag) {
        if (y == 0 && x == 0)
            return;

        windy(y,x,dir);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("------------");

        if(cnt !=0 ){
            dfs(y+dy[dir],x+dx[dir],cnt-1,dir,abs,flag);
        }
        else{
            dir++;
            flag++;
            if(dir==4)
                dir=0;
            if(flag >= 2){
                abs++;  
                flag=0;
            }
            dfs(y+dy[dir],x+dx[dir],abs,dir,abs,flag);
        }


    }
}
