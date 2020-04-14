package com.ssafy.edu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_다항식계산 {
	static long[] dp;
	static int mod =998244353;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = null;
			ArrayList<int[]> list =new ArrayList<>();
			dp = new long[N+1];
			for (int i = 0; i <N-1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int [] temp = new int[3];
				for (int j = 0; j < 3; j++) {
					temp[j]=Integer.parseInt(st.nextToken());
				}
				list.add(temp);
			}
			int M = Integer.parseInt(br.readLine());
			int[] x = new int[M];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < x.length; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			dp[0] = 1;
			int t = 0; int a=0;  int b=0;
			long [] solution = new long[M];
			for (int i = 0; i < x.length; i++) {
				dp[1]=x[i];
				for (int j = 0; j < N-1; j++) {
					int[] temp =list.get(j);
					t =temp[0];
					a = temp[1];
					b= temp[2];
					if(t == 1) {
						dp[j+2]=(dp[a]+dp[b])%mod;
					}else if(t== 2) {
						dp[j+2]=(a*dp[b])%mod;
					}else if(t==3) {
						dp[j+2]=(dp[a]*dp[b])%mod;
					}
				}
				solution[i]=dp[N];
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#"+tc);
			for (long i : solution) {
				sb.append(" "+i);
			}
			System.out.println(sb.toString());
	
		}
	}
}
