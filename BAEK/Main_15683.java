import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15683 {
    static int n, m;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        Queue<int[]> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] < 6 && map[i][j] > 0) {
                    list.add(new int[]{i, j, map[i][j]});
                }
            }
        }
        answer = counting(list);
        System.out.print(answer);
    }

    private static int counting(Queue<int[]> list) {
        int[][] temp = new int[n][m];
        for (int k = 0; k < n; k++) {
            temp[k] = map[k].clone();
        }
        Queue<int[][]> maplist = new LinkedList<>();
        maplist.add(temp);
        while (!list.isEmpty()) {
            int[] now = list.poll();
            int size = maplist.size();
            for (int z = 0; z < size; z++) {
                int[][] nowmap = maplist.poll();
                int i = now[0];
                int j = now[1];
                int dir = now[2];
                int[][] upmap = new int[n][m];
                int[][] downmap = new int[n][m];
                int[][] leftmap = new int[n][m];
                int[][] rightmap = new int[n][m];
                for (int k = 0; k < n; k++) {
                    upmap[k] = nowmap[k].clone();
                    downmap[k] = nowmap[k].clone();
                    leftmap[k] = nowmap[k].clone();
                    rightmap[k] = nowmap[k].clone();
                }
                int[][] up = dfs(i + dy[0], j + dx[0], 0, upmap);
                int[][] down = dfs(i + dy[1], j + dx[1], 1, downmap);
                int[][] left = dfs(i + dy[2], j + dx[2], 2, leftmap);
                int[][] right = dfs(i + dy[3], j + dx[3], 3, rightmap);
                if (dir == 1) {
                    maplist.offer(up);
                    maplist.offer(down);
                    maplist.offer(left);
                    maplist.offer(right);
                } else if (dir == 2) {
                    int[][] updown = new int[n][m];
                    int[][] leftright = new int[n][m];
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < m; l++) {
                            if (up[k][l] <= 0) {
                                updown[k][l] = up[k][l] + down[k][l];
                                leftright[k][l] = left[k][l] + right[k][l];
                            } else {
                                updown[k][l] = up[k][l];
                                leftright[k][l] = up[k][l];
                            }
                        }
                    }
                    maplist.offer(updown);
                    maplist.offer(leftright);

                } else if (dir == 3) {
                    int[][] upleft = new int[n][m];
                    int[][] upright = new int[n][m];
                    int[][] downleft = new int[n][m];
                    int[][] downright = new int[n][m];
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < m; l++) {
                            if (up[k][l] <= 0) {
                                upleft[k][l] = up[k][l] + left[k][l];
                                upright[k][l] = up[k][l] + right[k][l];
                                downleft[k][l] = down[k][l] + left[k][l];
                                downright[k][l] = down[k][l] + right[k][l];
                            } else {
                                upleft[k][l] = up[k][l];
                                upright[k][l] = up[k][l];
                                downright[k][l] = up[k][l];
                                downleft[k][l] = up[k][l];
                            }
                        }
                    }
                    maplist.offer(upleft);
                    maplist.offer(upright);
                    maplist.offer(downright);
                    maplist.offer(downleft);
                } else if (dir == 4) {
                    int[][] one = new int[n][m];
                    int[][] two = new int[n][m];
                    int[][] three = new int[n][m];
                    int[][] four = new int[n][m];
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < m; l++) {
                            if (up[k][l] <= 0) {
                                one[k][l] = up[k][l] + down[k][l] + left[k][l];
                                two[k][l] = up[k][l] + down[k][l] + right[k][l];
                                three[k][l] = down[k][l] + left[k][l] + right[k][l];
                                four[k][l] = up[k][l] + left[k][l] + right[k][l];
                            } else {
                                one[k][l] = up[k][l];
                                two[k][l] = up[k][l];
                                three[k][l] = up[k][l];
                                four[k][l] = up[k][l];
                            }
                        }
                    }
                    maplist.add(one);
                    maplist.add(two);
                    maplist.add(three);
                    maplist.add(four);
                } else {
                    int[][] total = new int[n][m];
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < m; l++) {
                            if (up[k][l] <= 0) {
                                total[k][l] = up[k][l] + down[k][l] + left[k][l] + right[k][l];
                            } else
                                total[k][l] = up[k][l];
                        }
                    }
                    maplist.add(total);
                }
            }
        }
        int max = 10000;
        while (!maplist.isEmpty()) {
            int temps = 0;
            int[][] now = maplist.poll();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (now[i][j] == 0)
                        temps++;
                }
            }
            max = Math.min(max, temps);
        }
        return max;
    }

    private static int[][] dfs(int y, int x, int dir, int[][] maps) {
        if (check(y, x)) {
            if (maps[y][x] <= 0) {
                maps[y][x] = -1;
            }
            if (maps[y][x] < 6)
                maps = dfs(y + dy[dir], x + dx[dir], dir, maps);
        }
        return maps;
    }

    private static boolean check(int y, int x) {
        if (y >= n || x >= m || y < 0 || x < 0 || map[y][x] == 6)
            return false;
        return true;
    }


}
