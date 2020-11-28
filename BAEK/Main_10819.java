package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_10819 {
    static boolean[] check;
    static ArrayList<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            arr.add(Integer.parseInt(st.nextToken()));
        check = new boolean[n];
        int result = per(new int[n],0,n);
        System.out.println(result);
    }

    public static int per(int[] arrary, int idx, int n) {
        if (idx == n) {
            int val = 0;
            for (int i = 0; i < arrary.length-1; i++) {
                val+=Math.abs(arrary[i]-arrary[i+1]);
            }
            return val;
        }
        int val = 0;
        for (int i = 0; i < check.length; i++) {
            if (check[i])
                continue;
            else {
                check[i] = true;
                arrary[idx] = arr.get(i);
                val= Math.max(val,per(arrary,idx+1,n));
                check[i] = false;
            }
        }
        return val;
    }
}
