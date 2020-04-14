package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D5_2814_흑백트리 {
	static int T, N;
	static List<Integer>[] adj;
	static int MOD = 1000000007;
	static long[][] memo;// 색상 ,정점 번호

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			adj = new ArrayList[N + 1];
			for (int i = 1; i < N + 1; i++) {
				adj[i] = new ArrayList<>();
			}
			memo = new long[2][N + 1];
			for (int i = 1; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				adj[b].add(a);
			}
			long ans = (dfs(1, 0, -1) + dfs(1, 1, -1)) % MOD;
			System.out.println("#" + test + " " + ans);

		}

	}

	static long dfs(int v, int color, int parent) {
		// memo[color][v] 값이 존재하면 계산 x return.
		if (memo[color][v] != 0) {
			return memo[color][v];
		}
		long ret = 1;
		// 색이 흑 (0) 인경우
		// 자식 노드들을 백으로 칠한경우의 경웃의수들의 곱
		if (color == 0) {
			// 현재정점 v에서 연결된 모든 간선에 대해서.
			for (int i = 0; i < adj[v].size(); i++) {
				if (adj[v].get(i) != parent) {
					ret *= dfs(adj[v].get(i), 1, v);
					ret %= MOD;

				}
			}

		}

		// 색이 백 (!)인 경우
		if (color == 1) {
			// 현재정점 v에서 연결된 모든 간선에 대해서.
			for (int i = 0; i < adj[v].size(); i++) {
				if (adj[v].get(i) != parent) {
					ret *= (dfs(adj[v].get(i), 1, v) + dfs(adj[v].get(i), 0, v));
					ret %= MOD;

				}
			}
		}
		// 자식노드들을 흑으로 칠한경우의 경우의수들의곱
		// +_
		// 자식노드들을 백으로 칠한 경우의 경우의수들의곱
		memo[color][v] = ret;

		return ret;
	}

}
