package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_1138 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] tail = new int[N];
        for (int i = 1; i <= N; i++) {
            int left = Integer.parseInt(st.nextToken());
            for (int j = 0; j < N; j++) {
                if(left == 0 && tail[j]==0) {
                    tail[j] = i;
                    break;
                }
                else if(tail[j] == 0)
                    left--;
                }
            }
        StringBuffer sb = new StringBuffer();
        sb.append(tail[0]);
        for (int i = 1; i < tail.length; i++) {
            sb.append(" "+tail[i]);
        }
        System.out.println(sb.toString());


    }
}
