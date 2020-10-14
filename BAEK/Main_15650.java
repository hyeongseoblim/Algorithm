import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650 {
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
        check= new boolean[n];
        dfs(1,0);
        System.out.println(sb.toString().substring(0, sb.toString().length() - 1));

    }

    private static void dfs(int now,int cnt) {
        if (cnt == m) {
            String ans = "";
            for (int i = 0; i < n; i++) {
                if (check[i])
                    ans += i+1 + " ";
            }
            sb.append(ans.trim() + "\n");
            return;
        }
        for (int i = now; i <= n; i++) {
            if (!check[i-1]) {
                check[i-1] = true;
                dfs(i,cnt + 1);
                check[i-1] = false;
            }
        }
    }
}
