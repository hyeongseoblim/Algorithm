import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());
        int count = 0;
        String comm = "";
        boolean state = true;
        int left, right = 0;
        for (int i = 0; i < t; i++) {
            comm = br.readLine().replace("RR", "");
            char[] command = comm.toCharArray();
            count = Integer.parseInt(br.readLine());
            left = 0;
            right = 0;
            state = true;
            char[] arr = br.readLine().replace("[", "").replace("]", "").replace(",", "").toCharArray();
            for (char com : command) {
                if (com == 'R')
                    state = !state;
                else {
                    if (state)
                        left++;
                    else
                        right++;
                }
            }
            if (left + right > count)
                sb.append("error\n");
            else {
                if (arr.length == 0)
                    sb.append("[]\n");
                else {
                    if (state) {
                        sb.append("[");
                        for (int j = left; j < count - right - 1; j++) {
                            sb.append(String.valueOf(arr[j]) + ',');
                        }
                        sb.append(String.valueOf(arr[count - right - 1]) + "]\n");
                    } else {
                        sb.append("[");
                        for (int j = count - right - 1; j > left; j--) {
                            sb.append(String.valueOf(arr[j]) + ',');
                        }
                        sb.append(String.valueOf(arr[left]) + "]\n");
                    }
                }
            }
        }
        System.out.println(sb.toString().substring(0, sb.toString().length() - 1));

    }
}
