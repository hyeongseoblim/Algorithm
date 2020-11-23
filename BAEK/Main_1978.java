package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1978 {
    static boolean[] prime = new boolean[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int [] arr = new int[t];
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]=false;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < t; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            max =Math.max(max,arr[i]);
        }
        eratos(max);
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if(prime[arr[i]])
                result++;
        }
        System.out.println(result);
    }
    private static void eratos(int n){
        for (int i = 2; i < (int)Math.sqrt(n)+1 ; i++) {
            if (prime[i]) {
                int j = 2;
                while(i*j <= n){
                    prime[i*j]=false;
                    j+=1;
                }
            }
        }
    }
}
