import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long sum=0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            int t = Integer.parseInt(st.nextToken());
            for(int j=0; j<t; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            sum =0;
            for (int j = 0; j < list.size(); j++) {
                for (int k = j+1; k < list.size() ; k++) {
                    if(j==k)
                        continue;
                    else
                        sum+=gcd(list.get(j),list.get(k));
                }
            }
            System.out.println(sum);
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
