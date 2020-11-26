package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095 {
    static int n;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            cnt = 0;
            dfs(0);
            System.out.println(cnt);
        }


    }

    private static void dfs(int val) {
        if (val == n) {
            cnt++;
            return;
        } else if (val > n)
            return;
        else {
            dfs(val + 1);
            dfs(val + 2);
            dfs(val + 3);
        }
    }
}
