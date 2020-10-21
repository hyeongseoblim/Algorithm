import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074 {
    static int N, r, c, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cnt = 0;
        dfs(0, 0, (int) Math.pow(2,N));
    }

    static void dfs(int y, int x, int size) {
        if(size == 1) {
            if (y == r && x == c) {
                System.out.print(cnt);
            }
            cnt++;
            return;
        }
        int s = size / 2;
        if (size > 1) {
            dfs(y, x, s);
            dfs(y, x + s, s);
            dfs(y + s, x, s);
            dfs(y + s, x + s, s);
        }
    }
}
