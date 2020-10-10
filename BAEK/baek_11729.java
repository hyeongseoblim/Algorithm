import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_11729 {
    static int num;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        num = 0;
        func(1, 3,n);
        System.out.println(num);
        System.out.println(sb.toString().substring(0,sb.toString().length()-1));
    }

    private static void move(int start, int end) {
        num += 1;
        sb.append(start+" "+end);
        sb.append("\n");
    }

    private static void func(int a, int b, int n) {
        if (n == 0)
            return;
        else {
            int other = 6 - a - b;
            func(a, other, n - 1);
            move(a, b);
            func(other, b, n - 1);
        }
    }
}
