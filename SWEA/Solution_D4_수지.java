package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_수지 {
	static int T, R, C;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int ans;
	static boolean[] alp;
	static String[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			ans = 0;
			map = new String[R][C];
			for (int i = 0; i < map.length; i++) {
				map[i] = br.readLine().split("");
			}
			alp = new boolean[26];
			alp[map[0][0].charAt(0) - 'A'] = true;
			dfs(0, 0, 1);

			System.out.println("#" + test + " " + ans);
		}

	}

	public static void dfs(int y, int x, int cnt) {
		if (ans < cnt) {
			ans = cnt;
		}
		if (cnt == 26) {
			return;
		}
		alp[map[y][x].charAt(0) - 'A'] = true;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny >= 0 && ny < R && nx >= 0 && nx < C && !alp[map[ny][nx].charAt(0) - 'A']) {
				dfs(ny, nx, cnt + 1);
			}
		}
		alp[map[y][x].charAt(0) - 'A'] = false;

	}
}
