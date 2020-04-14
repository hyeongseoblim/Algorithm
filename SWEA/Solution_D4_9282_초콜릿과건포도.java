package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//완탐
public class Solution_D4_9282_초콜릿과건포도 {
	static int T;
	static int N, M;
	static int[][] map;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 사이즈 정해졌으면
			int ans = 0;
			// 처리 -> 재귀로 처리 처음부터 .. 전체 사이즈만한걸로
			ans = dfs(0, 0, N, M, Integer.MAX_VALUE);
			// 출력

			System.out.println("#" + test + " " + ans);

		}
	}

	private static int dfs(int y, int x, int h, int w, int min) {
		// 커다란 조각에서 얻어지는 비용 구하기.
		// 작은 조각으로 가자 -> 재귀호출
		// 기저조건
		if (w == 1 && h == 1) {
			return 0;
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
			int sum1 = dfs(y, x, i, w, min);
			// 아래쪽 비용
			int sum2 = dfs(y + i, x, h - i, w, min);
			// 전체 비용
			int sum3 = sum + sum1 + sum2;

			min = Math.min(min, sum3);
		}
		// 세로로 나누었을때 최소비용
		for (int i = 1; i < w; i++) {
			int sum1 = dfs(y, x, h, i, min);
			int sum2 = dfs(y, x + i, h, w - i, min);
			int sum3 = sum + sum1 + sum2;
			min = Math.min(min, sum3);
		}

		return min;
	}

}
