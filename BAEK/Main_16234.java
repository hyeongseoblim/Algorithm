
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class Main_16234 {
    static int n,l,r;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new int[n][n];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        
        int result = 0;
        while(true) {
            boolean check = false; // 인구 이동이 일어났나 확인하는 변수
            teamN = 0;
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(visited[i][j]==0) {
                        if(solve(i,j)) check = true;
                    }
                }
            }
            if(check) result++; // 인구 이동이 일어났으면 +1
            else break; // 인구 이동이 일어나지 않았으면 종료
            
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++)
                    visited[i][j] = 0;
            }
        }
        System.out.println(result);
    }
    
    static int teamN;
    static int[][] visited;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private static boolean solve(int x,int y) {
        Queue<Pair> queue = new LinkedList<>();
        teamN++; // 각각의 연합에 번호를 부여하기 위해서
        queue.add(new Pair(x, y));
        visited[x][y] = teamN;
        int tHuman = arr[x][y];
        int tCnt = 1;
        while(!queue.isEmpty()) {
            Pair t = queue.poll();
            
            for(int i=0;i<4;i++) {
                int tx = t.x+dir[i][0];
                int ty = t.y+dir[i][1];
                if(tx<0 || ty<0 || tx>=n || ty>=n) continue;
                // 방문 체크 & 연합 구별
                if(visited[tx][ty]!=0) continue;
                // 두 나라의 차이가 범위안이라면
                if(check(arr[t.x][t.y], arr[tx][ty])) {
                    visited[tx][ty] = teamN;
                    tCnt++; // 연합 수 세기
                    tHuman+=arr[tx][ty]; // 인구 수 더하기
                    queue.add(new Pair(tx, ty));
                }
            }
        }
        
        // 같은 연합 인구 나누기
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(visited[i][j]==teamN) {
                    arr[i][j] = tHuman/tCnt;
                }
            }
        }
        // tCnt가 1보다 크다는 것은 인구이동이 일어 났다는 것이다.
        if(tCnt>1) return true;
        else return false;
    }
    
    // 국경 체크
    private static boolean check(int n1,int n2) {
        int t = Math.abs(n1-n2);
        // 두 나라의 차이가 l명이상 r명 이하라면
        if(t>=l&&t<=r) return true;
        else return false;
    }
    
    static class Pair{
        int x,y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}