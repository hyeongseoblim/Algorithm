package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_2814_최장경로 {
	static int T, cnt, N, M;
	static int[][] map;
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			cnt = 1;
			map = new int[N + 1][N + 1];
			visited = new boolean[N + 1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from][to] = 1;
				map[to][from] = 1;
			}
			for (int i = 1; i <= N; i++) {
				visited[i] = true;
				dfs(i, 1);
				visited[i] = false;
			}
			System.out.println("#" + test + " " + cnt);

		}
	}

	private static void dfs(int idx, int csnt) {
		// 방문 노드 x
		cnt = Math.max(cnt, csnt);
		visited[idx] = true;
		// 간선 존재하고 아직 방문 x
		for (int j = 1; j <=N; j++) {
			if (map[idx][j] != 0 && !visited[j]) {
				visited[j] = true;
				dfs(j, csnt + 1);
				visited[j] = false;
			}
		}
	}

}
