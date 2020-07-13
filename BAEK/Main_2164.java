import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        LinkedList<Integer>list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        while(list.size()!=1){
            list.remove(0);
            int temp = list.get(0);
            list.remove(0);
            list.add(temp);
        }
        bw.append(String.valueOf(list.get(0)));
        bw.flush();
        bw.close();
        br.close();

    }
}
