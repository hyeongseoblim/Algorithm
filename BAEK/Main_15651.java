import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15651 {
    static StringBuffer sb;
    static int n, m;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new int[n];
        dfs(0);
        System.out.print(sb.toString());
    }

    private static void dfs(int cnt) {
        if (cnt == m) {
            String temp = "";
            for (int i = 0; i < m; i++) {
                    temp +=  check[i]+" ";
                }
            sb.append(temp.trim()+"\n");
            return;
        }
        for (int j = 1; j <= n; j++) {
            check[cnt]=j;
            dfs(cnt+1);
        }
    }


}
