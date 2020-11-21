package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= T; i++) {
            char[] line = br.readLine().toCharArray();
            int[] alpa = new int[26];
            for (char a : line) {
                alpa[(int) a - 97]++;
            }
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < alpa.length; j++) {
                if(alpa[j]%2==0)
                    continue;
                else
                    sb.append((char)(j+97));
            }
            if(sb.toString().length()==0)
                System.out.println("#"+i+" Good");
            else
                System.out.println("#"+i+" "+sb.toString());
        }

    }
}
