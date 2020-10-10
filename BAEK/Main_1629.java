import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(multi(a,b,c));
    }
    private static long multi(long a, long b, long c){
        if(b == 0)
            return 1;
        if(b == 1)
            return a%c;
        long val = multi(a,b/2,c);
        val = val*val%c;
        if (b%2 == 0) return val;
        return val*a%c;
    }
}
