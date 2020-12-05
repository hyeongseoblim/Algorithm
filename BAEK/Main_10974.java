package BAEK;

import java.io.BufferedReader;
import java.util.Scanner;

public class Main_10974 {
    static int [] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        permutation(new int[n], new boolean[n],0,0);

    }
    public static void permutation(int[] array, boolean[] visit, int cnt ,int idx){
        if(cnt == arr.length){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]+" ");
            }
            sb.deleteCharAt(sb.toString().length()-1);
            System.out.println(sb.toString());
            return;
        }
        for (int i = 0; i < visit.length; i++) {
            if(!visit[i]){
                visit[i]=true;
                array[idx]=arr[i];
                permutation(array,visit,cnt+1 ,idx+1);
                visit[i]=false;
            }
        }
    }
}
