package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12500 {
    static int n, m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }

    public static boolean check(int y, int x) {
        if (y >= n || x >= m || x < 0 || y < 0)
            return false;
        return true;
    }

    public static int solve(int[][] board,int y,int x) {
        int answer = 0;




        return answer;
    }

    public static int[][] copyarray(int[][] board) {
        int[][] answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer[i][j] = board[i][j];
            }
        }
        return answer;
    }

    public static int[][] rotate(int[][] map) {
        int[][] temp = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                temp[j][map.length - 1 - i] = map[i][j];
            }
        }
        return temp;
    }
}
