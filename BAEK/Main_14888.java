import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888 {
    static int[] flag = new int[4];
    static int n;
    static int[] array;
    static boolean[] check;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        array = new int[n];
        check = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            flag[i] = Integer.parseInt(st.nextToken());
        }
        result(0, array[0]);
        System.out.println(max + "\n" + min);
    }

    static void result(int idx, int ans) {
        if (idx == n - 1) {
            max = Math.max(ans, max);
            min = Math.min(ans, min);
            return;
        }
        int temp = ans;
        for (int i = 0; i < 4; i++) {
            if (flag[i] != 0) {
                flag[i] -= 1;
                switch (i) {
                    case 0:
                        ans += array[idx+1];
                        break;
                    case 1:
                        ans -= array[idx+1];
                        break;
                    case 2:
                        ans *= array[idx+1];
                        break;
                    case 3:
                        ans /= array[idx+1];
                        break;
                }
                result(idx + 1, ans);
                ans = temp;
                flag[i] += 1;
            }
        }
    }
}
