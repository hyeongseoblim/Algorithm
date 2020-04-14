package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//메모이제이션 사용
public class Solution_D4_9282_초콜릿과건포도2 {
	static int T;
	static int N, M;
	static int[][] map;
	static int[][][][] dp;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			dp = new int[N + 1][M + 1][N + 1][M + 1];
			// y x h w
			for (int[][][] a : dp) {
				for (int[][] b : a) {
					for (int[] c : b) {
						Arrays.fill(c, Integer.MAX_VALUE);
					}
				}
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 사이즈 정해졌으면
			int ans = 0;
			// 처리 -> 재귀로 처리 처음부터 .. 전체 사이즈만한걸로
			ans = dfs(0, 0, N, M);
			// 출력

			System.out.println("#" + test + " " + ans);

		}
	}

	private static int dfs(int y, int x, int h, int w) {
		// 커다란 조각에서 얻어지는 비용 구하기.
		// 작은 조각으로 가자 -> 재귀호출
		// 기저조건
		if (w == 1 && h == 1) {
			return 0;
		}
		if (dp[y][x][h][w] != Integer.MAX_VALUE) {
			return dp[y][x][h][w];
		}
		int sum = 0;
		for (int i = y; i < y + h; i++) {
			for (int j = x; j < x + w; j++) {
				sum += map[i][j];
			}
		}

		// 재귀호출
		// 가로로 나누었을때 최소비용
		for (int i = 1; i < h; i++) {
			// 위쪽 비용
			if (dp[y][x][i][w] == Integer.MAX_VALUE) {
				dp[y][x][i][w] = dfs(y, x, i, w);
			} // 아래쪽 비용
			if (dp[y + i][x][h - i][w] == Integer.MAX_VALUE) {
				dp[y + i][x][h - i][w] = dfs(y + i, x, h - i, w);
				// 전체 비용
			}
			int sum3 = sum + dp[y][x][i][w] + dp[y + i][x][h - i][w];

			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
		}
		// 세로로 나누었을때 최소비용
		for (int i = 1; i < w; i++) {
			if (dp[y][x][h][i] == Integer.MAX_VALUE) {
				dp[y][x][h][i] = dfs(y, x, h, i);
			}
			if (dp[y][x + i][h][w - i] == Integer.MAX_VALUE) {
				dp[y][x + i][h][w - i] = dfs(y, x + i, h, w - i);
			}
			int sum3 = sum + dp[y][x][h][i] + dp[y][x + i][h][w - i];
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
		}

		return dp[y][x][h][w];
	}

}
