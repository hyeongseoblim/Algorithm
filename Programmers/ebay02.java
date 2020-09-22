import java.io.*;

public class ebay02 {
    static int min = 99999999;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        String [] ff = br.readLine().split("");
        int []ne = new int [ff.length];
        int idx =0;
        for (String s: ff) {
            ne[idx]=Integer.parseInt(ff[idx]);
            idx++;
        }
        int res = dfs(0,ne,0);

    }
    static int dfs(int num , int[]ne, int cnt){
        if(num == n){
            min = Math.min(cnt,min);
            return min;}

            dfs(num,ne,cnt+1);

        return min;
    }
}
