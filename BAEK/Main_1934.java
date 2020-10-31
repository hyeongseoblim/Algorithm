import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            System.out.println(lcm(first,second));
        }
    }
    public static int gcd(int f, int s) {
        if (s == 0) return f;
        else
            return gcd(s,f%s);
    }

    public static int lcm(int f, int s) {

        int a = gcd(f,s);
        return (f*s/a);
    }
}
