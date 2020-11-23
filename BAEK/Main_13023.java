package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_13023 {
    static int n,t;
    static ArrayList<ArrayList<Integer>> group;
    static boolean [] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        group = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            group.add(new ArrayList<>());
        }
        int start = 0;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            group.get(a).add(b);
            group.get(b).add(a);
            start =a;
        }
        for (int i = 0; i < n; i++) {
            visit = new boolean[n];
            if (dfs(i, 1)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);

    }
    static boolean dfs(int idx, int depth){
        if(depth == 5)
            return true;
        visit[idx]=true;
        for (int i = 0; i < group.get(idx).size(); i++) {
            int now =group.get(idx).get(i);
            if(visit[now])
                continue;
            else{
                if(dfs(now,depth+1)) return true;
            }
        }
        visit[idx]=false;
        return false;
    }
}
