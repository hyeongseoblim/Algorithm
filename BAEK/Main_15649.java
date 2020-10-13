import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649 {
    static boolean[] check;
    static int[] array;
    static int n, m;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n];
        check = new boolean[n];
        dfs(0);
        System.out.println(sb.toString().substring(0, sb.toString().length() - 1));

    }

    private static void dfs(int cnt) {
        if (cnt == m) {
            String ans = "";
            for (int i = 0; i < m; i++) {
                if (check[array[i]-1])
                    ans += array[i] + " ";
            }
            sb.append(ans.trim() + "\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!check[i-1]) {
                array[cnt] = i;
                check[i-1] = true;
                dfs(cnt + 1);
                check[i-1] = false;
            }
        }
    }
}
