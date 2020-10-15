import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4179 {
    static int R, C;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static char[][] map;
    static int count;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = change(st.nextToken());
        C = change(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        count = 0;

        Queue<int[]> stque = new LinkedList<>();
        Queue<int[]> frque = new LinkedList<>();
        for (int i = 0; i < map.length; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = temp[j];
                if (map[i][j] == 'J') {
                    stque.add(new int[] { i, j });
                    visited[i][j] = true;
                } else if (map[i][j] == 'F') {

                    frque.add(new int[] { i, j });
                }
            }
        }

        boolean flag = bfs(stque, frque);
        if (flag)
            System.out.println(count);
        else
            System.out.println("IMPOSSIBLE");
    }

    public static boolean bfs(Queue<int[]> a, Queue<int[]> b) {
        int mov_count = 0;
        while (true) {
            while (!b.isEmpty()) {
                int size = b.size();
                int idx = 0;
                for (int i = 0; i < size; i++) {
                    int fnow[] = b.poll();
                    int fire_y = fnow[0];
                    int fire_x = fnow[1];

                    for (int j = 0; j < 4; j++) {
                        int next_fy = fire_y + dy[j];
                        int next_fx = fire_x + dx[j];
                        if (check(next_fy, next_fx) && map[next_fy][next_fx] == '.') {
                            map[next_fy][next_fx] = 'F';
                            b.add(new int[] { next_fy, next_fx });
                        }
                    }
                    idx++;
                }
                if (idx == size) {
                    idx = 0;
                    break;
                }
            }
            while (!a.isEmpty()) {
                int size2 = a.size();
                int idx2 = 0;
                int moving = 0;
                for (int i = 0; i < size2; i++) {
                    int now[] = a.poll();
                    int player_y = now[0];
                    int player_x = now[1];

                    for (int j = 0; j < 4; j++) {
                        int next_py = player_y + dy[j];
                        int next_px = player_x + dx[j];
                        if (check(next_py, next_px)) {
                            if (map[next_py][next_px] == '.' && visited[next_py][next_px] == false) {
                                visited[next_py][next_px] = true;
                                map[player_y][player_x] = '.';
                                map[next_py][next_px] = 'J';
                                moving++;
                                mov_count++;
                                a.add(new int[] { next_py, next_px });
                            }
                        } else {
                            count++;
                            return true;
                        }

                    }

                    idx2++;

                }
                if (moving > 0) {
                    count++;
                    moving = 0;
                }
                if (idx2 == size2) {
                    idx2 = 0;
                    break;
                }
            }
            if (mov_count == 0) {
                return false;
            }
            if(a.isEmpty()&&b.isEmpty()) {
                break;
            }
        }
        return false;

    }

    static int change(String s) {
        return Integer.parseInt(s);
    }



    static boolean check(int y, int x) {
        if (y >= 0 && y < R && x >= 0 && x < C) {
            return true;
        }
        return false;
    }
}