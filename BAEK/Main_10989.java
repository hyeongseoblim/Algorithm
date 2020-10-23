import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10989 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[10001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                for (int j = 0; j < arr[i]; j++) {
                    sb.append(i).append("\n");
                }
            }
        }
        System.out.print(sb.toString().trim());
    }
}
