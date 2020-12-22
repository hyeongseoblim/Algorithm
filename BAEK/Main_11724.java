package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_11724 {
    static int N,M;
    static boolean []check;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check=new boolean[N+1];
        list = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list.get(key).add(value);
            list.get(value).add(key);
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (!check[i + 1]) {
                check[i+1]=true;
                dfs(i + 1);
                result += 1;
            }
        }
        System.out.println(result);
        
    }
    static void dfs(int idx){
        if(list.get(idx).size()!=0){
            for (int i = 0; i < list.get(idx).size(); i++) {
                if (check[list.get(idx).get(i)])
                    continue;
                else {
                    check[list.get(idx).get(i)]=true;
                    dfs(list.get(idx).get(i));
                }
            }
        }
    }
}
