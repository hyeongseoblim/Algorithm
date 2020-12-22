package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class  unionfind {
    static int[] parent;
    public static int find( int now){
        if(parent[now] != now)
            return find(parent[now]);
        return parent[now];
    }
    public static void union(int a, int b){
        a=find(a);
        b=find(b);
        if (a<b)
            parent[b]=a;
        else
            parent[a]=b;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for (int i = 0; i <= n; i++) {
            parent[i]=i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        System.out.print("각 원소가 속한 집합: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(find(i) + " ");
        }
        System.out.println();

        // 부모 테이블 내용 출력하기
        System.out.print("부모 테이블: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }

}
