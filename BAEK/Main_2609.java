import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        System.out.println(gcd(first,second));
        System.out.println(lcm(first,second));
    }

    public static int gcd(int f, int s) {
        int a = f;
        int b = s;
        if (b > a) {
            b = f;
            a = s;
        }
        if (a % b == 0)
            return s;
        else
          return gcd(b,a%b);
    }

    public static int lcm(int f, int s) {
        int a = gcd(f,s);
        int fa = f/a;
        int sa = s/a;
        return a*(fa*sa);
    }
}
