import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2000001];
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp < 0) {
                temp = Math.abs(temp) + 1000000;
            }
            arr[temp]++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 2000000; i > 1000000; i--) {
            if (arr[i] >0) {
                for (int j = 0; j < arr[i]; j++) {
                    sb.append(-1 * i + 1000000).append("\n");
                }
            }
        }
        for (int i = 0; i < 1000001; i++) {
            if (arr[i] >0) {
                for (int j = 0; j < arr[i]; j++) {
                    sb.append(i).append("\n");
                }
            }
        }
        System.out.print(sb.toString().trim());
    }
}