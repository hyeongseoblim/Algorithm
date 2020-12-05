package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759 {
    static int N, R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        char[] list = new char[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i]= st.nextToken().charAt(0);
        }
        Arrays.sort(list);
        dfs(list,new boolean[N],0,0);
    }
    public static void dfs(char[] arr, boolean[] visit, int start, int count){
        if(count == R){
            boolean flag =false;
            int cnt =0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <visit.length; i++) {
                if(visit[i]){
                    if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u')
                        flag=true;
                    else
                        cnt++;
                    sb.append(arr[i]);
                }
            }
            if(flag&&cnt>=2){
                System.out.println(sb.toString());
            }
            return;
        }
        for (int i = start; i < visit.length; i++) {
            if(!visit[i]){
                visit[i]=true;
                dfs(arr,visit,i+1,count+1);
                visit[i]=false;
            }
        }
    }
}
