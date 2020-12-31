package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        int w = Integer.parseInt(st.nextToken());
//        int[] trucks = new int[n];
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            trucks[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int time = 0;
//        for (int i = 0; i < n; i++) {
//            int now = trucks[i];
//            if()
//        }
        int time = 0;
        int e = 8;
        while(e!=0){
            e/=2;
            time++;
        }
        System.out.println(time);
    }
}
