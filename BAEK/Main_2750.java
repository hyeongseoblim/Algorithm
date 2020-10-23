import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2000001];
        boolean[] flag = new boolean[2000001];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp < 0) {
                temp = Math.abs(temp) + 1000000;
            }
            arr[temp]++;
            max = Math.max(max, temp);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = max; i > 1000000; i--) {
            if (arr[i] == 1) {
                sb.append(-1 * i + 1000000 + "\n");
            }
        }
        for (int i = 0; i < 1000001; i++) {
            if (arr[i] == 1) {
                sb.append(i + "\n");
            }
        }
        System.out.print(sb.toString().trim());
    }
}
