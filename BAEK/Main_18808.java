import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18808 {
    static int n, m, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        res = 0;
        int[][] map = new int[n][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[y][x];
            for (int j = 0; j < y; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < x; l++) {
                    sticker[j][l] = Integer.parseInt(st.nextToken());
                }
            }
            map = solve(map, sticker);
        }


        System.out.print(res);
    }

    public static boolean check(int y, int x, int[][] map, int[][] sticker) {
        if (map.length < sticker.length || map[0].length < sticker[0].length)
            return false;
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[i].length; j++) {
                if(i+y>map.length-1 || j+x>map[i].length-1)
                    return false;
                if (map[i + y][j + x] == 1 && sticker[i][j] == 1)
                    return false;
            }
        }
        return true;
    }

    public static int[][] solve(int[][] map, int[][] sticker) {
        for (int j = 0; j < 4; j++) {
            boolean flag = false;
            for (int l = 0; l < n; l++) {
                for (int o = 0; o < m; o++) {
                    flag = check(l, o, map, sticker);
                    if (flag) {
                        map = stickey(l, o, map, sticker);
                        return map;
                    }
                }
            }
            sticker = rotate(sticker);
        }
        return map;
    }

    public static int[][] stickey(int y, int x, int[][] map, int[][] sticker) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[i].length; j++) {
                if (map[i + y][j + x] == 0) {
                    map[i + y][j + x] = sticker[i][j];
                    if(map[i+y][j+x]==1)
                        res++;
                }
            }
        }
        return map;
    }

    public static int[][] rotate(int[][] map) {
        int[][] result;
        if (map.length != map[0].length)
            result = new int[map[0].length][map.length];
        else
            result = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                result[j][map.length - 1 - i] = map[i][j];
            }
        }
        return result;
    }
}
