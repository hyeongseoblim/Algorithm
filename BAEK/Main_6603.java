package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n==0)
                break;
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            combination(0,0,arr,new boolean[n]);
            System.out.println();
        }
    }
    public static void combination(int start,int count, int[] arr,boolean[] visit){
        if(count == 6){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < visit.length; i++) {
                if(visit[i])
                    sb.append(arr[i]+" ");
            }
            sb.deleteCharAt(sb.toString().length()-1);
            System.out.println(sb.toString());
            return;
        }
        for (int i = start; i < visit.length; i++) {
            if(!visit[i]){
                visit[i]=true;
                combination(i+1,count+1,arr,visit);
                visit[i]=false;
            }
        }
    }
}
