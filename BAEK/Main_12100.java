import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12100 {

    static int n;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, map);
        System.out.print(result);
    }

    static void dfs(int cnt, int[][] map) {
        if (cnt == 5) {
            print(map);
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max= Math.max(max,map[i][j]);
                }
            }
            result = Math.max(max,result);
            return;
        }
        boolean [][] visit = new boolean[n][n];

        int[][] temp = clonemap(map);
        int[][] upmap = up(map,visit);
        dfs(cnt + 1, upmap);

        int[][] downmap = down(map,visit);
        dfs(cnt + 1, downmap);

        int[][] leftmap = left(map,visit);
        dfs(cnt + 1, leftmap);

        int[][] rightmap = right(map,visit);
        dfs(cnt + 1, rightmap);

    }

    private static int[][] clonemap(int[][] map) {
        int[][] ret = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = map[i][j];
            }
        }
        return ret;
    }
    private static void print(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    static boolean check(int y, int x) {
        if (y >= n || x >= n || y < 0 || x < 0)
            return false;
        return true;
    }

    static int[][] right(int[][] maps, boolean[][]visit) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i][j] != 0 && !visit[i][j]) {
                    int cy = i;
                    int cx=  j;
                    int ny = cy;
                    int nx = cx + 1;
                    visit[cy][cx]=true;
                    boolean flag = false;
                    while (check(ny, nx)) {
                        if (maps[ny][nx] == 0) {
                            maps[ny][nx] = maps[cy][cx];
                            visit[ny][nx]=true;
                            maps[cy][cx] = 0;
                            visit[cy][cx]=false;
                        } else {
                            if (maps[ny][nx] == maps[cy][cx]&&!flag) {
                                maps[ny][nx] += maps[cy][cx];
                                visit[cy][cx]=false;
                                visit[ny][nx]=true;
                                flag =true;
                                maps[cy][cx] = 0;
                            } else {
                                break;
                            }
                        }
                        cy = ny;
                        cx = nx;
                        nx++;
                    }
                }
            }
        }
        return maps;
    }

    static int[][] left(int[][] maps, boolean[][]visit) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i][j] != 0 && !visit[i][j]) {
                    int cy = i;
                    int cx=  j;
                    int ny = cy;
                    int nx = cx - 1;
                    visit[cy][cx]=true;
                    boolean flag = false;
                    while (check(ny, nx)) {
                        if (maps[ny][nx] == 0) {
                            maps[ny][nx] = maps[cy][cx];
                            visit[ny][nx]=true;
                            maps[cy][cx] = 0;
                            visit[cy][cx]=false;
                        } else {
                            if (maps[ny][nx] == maps[cy][cx]&&!flag) {
                                maps[ny][nx] += maps[cy][cx];
                                visit[cy][cx]=false;
                                visit[ny][nx]=true;
                                flag =true;
                                maps[cy][cx] = 0;
                            } else {
                                break;
                            }
                        }
                        cy = ny;
                        cx = nx;
                        nx--;
                    }
                }
            }
        }
        return maps;
    }
    static int[][] down(int[][] maps, boolean[][]visit) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i][j] != 0 && !visit[i][j]) {
                    int cy = i;
                    int cx=  j;
                    int ny = cy+1;
                    int nx = cx;
                    visit[cy][cx]=true;
                    boolean flag = false;
                    while (check(ny, nx)) {
                        if (maps[ny][nx] == 0) {
                            maps[ny][nx] = maps[cy][cx];
                            visit[ny][nx]=true;
                            maps[cy][cx] = 0;
                            visit[cy][cx]=false;
                        } else {
                            if (maps[ny][nx] == maps[cy][cx]&&!flag) {
                                maps[ny][nx] += maps[cy][cx];
                                visit[cy][cx]=false;
                                visit[ny][nx]=true;
                                flag =true;
                                maps[cy][cx] = 0;
                            } else {
                                break;
                            }
                        }
                        cy = ny;
                        cx = nx;
                        ny++;
                    }
                }
            }
        }
        return maps;
    }
    static int[][] up(int[][] maps, boolean[][]visit) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i][j] != 0 && !visit[i][j]) {
                    int cy = i;
                    int cx=  j;
                    int ny = cy-1;
                    int nx = cx;
                    boolean flag =false;
                    visit[cy][cx]=true;
                    while (check(ny, nx)) {
                        if (maps[ny][nx] == 0) {
                            maps[ny][nx] = maps[cy][cx];
                            visit[ny][nx]=true;
                            maps[cy][cx] = 0;
                            visit[cy][cx]=false;
                        } else {
                            if (maps[ny][nx] == maps[cy][cx]&&!flag) {
                                maps[ny][nx] += maps[cy][cx];
                                visit[cy][cx]=false;
                                visit[ny][nx]=true;
                                flag =true;
                                maps[cy][cx] = 0;
                            } else {
                                break;
                            }
                        }
                        cy = ny;
                        cx = nx;
                        ny--;
                    }
                }
            }
        }
        return maps;
    }
}
