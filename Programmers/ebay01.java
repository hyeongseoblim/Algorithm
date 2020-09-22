import java.io.*;
import java.util.ArrayList;

public class ebay01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());




    }
    public static void sjf (int[][] times){
        int sum =0;
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end =  new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
                start.add(times[i][0]);
                end.add(times[i][1]);
        }

    }
}
