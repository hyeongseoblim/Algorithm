package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] line = new int[3];
        line[0] = Integer.parseInt(st.nextToken());
        line[1] = Integer.parseInt(st.nextToken());
        line[2] = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while(true){
           int e = cnt%15;
           int s = cnt%28;
           int m = cnt%19;
           if(e == line[0]-1 && s == line[1]-1 && m==line[2]-1)
                break;
            cnt++;
        }
        System.out.println(cnt+1);
    }
}
