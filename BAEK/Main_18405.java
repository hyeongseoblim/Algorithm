
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18405 {
    static class toxic implements Comparable<toxic> {
        int y;
        int x;
        int num;


        public toxic(int y, int x, int num) {
            this.y = y;
            this.x = x;
            this.num = num;
        }

        @Override
        public int compareTo(toxic o) {
            if (this.num > o.num)
                return 1;
            else
                return -1;
        }
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int n,answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        LinkedList<toxic> nums = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0)
                    nums.offer(new toxic(i, j, map[i][j]));
            }
        }
        Collections.sort(nums);
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int y= Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        bfs(map, nums, s, y, x);
        System.out.print(answer);
    }

    private static void bfs(int[][] map, LinkedList<toxic> nums, int s, int y, int x) {
        int cnt =0;
        Queue<toxic> que = nums;
        while (!que.isEmpty()) {
            int size = que.size();
            if (cnt == s){
                if(map[y-1][x-1]!=0)
                    answer = map[y-1][x-1];
                else
                    answer = 0;
                break;
            }
            for (int i = 0; i < size; i++) {
                toxic now = nums.poll();
                int cy = now.y;
                int cx = now.x;
                int num = now.num;
                for (int j = 0; j < 4; j++) {
                    int ny = cy + dy[j];
                    int nx = cx + dx[j];
                    if (check(ny, nx)){
                        if(map[ny][nx] == 0){
                            map[ny][nx] = num;
                            nums.offer(new toxic(ny,nx,num));
                        }
                    }
                }
            }
            cnt ++;
        }

        if(map[y-1][x-1]!=0)
            answer = map[y-1][x-1];
        else
            answer = 0;

    }

    private static boolean check(int ny, int nx) {
        if (ny >= n || nx >= n || nx<0 || ny<0)
            return false;
        else
            return true;
    }
}
