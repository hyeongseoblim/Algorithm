package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_디저트카페 {
	static int T, N, cnt;
	static int[] dy = { 1, 1, -1, -1 };
	static int[] dx = { 1, -1, -1, 1 };
	static int[][] map;
	static int start;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = change(br.readLine().trim());
			map = new int[N][N];

			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < map.length; j++) {
					map[i][j] = change(st.nextToken());
				}
			}
			cnt = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					int[] count = new int[101];
					start = i * N + j;
					dfs(i, j, 0, 1, count);
				}
			}
			if (cnt == 0) {
				cnt = -1;
			}

			System.out.println("#" + test + " " + cnt);

		}
	}

	static void dfs(int y, int x, int dir, int dep, int[] count) {

		count[map[y][x]] = 1;
		for (int i = dir; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (dep >= 4 && (ny * N + nx) == start) {
				if (cnt < dep) {
					cnt = dep;
					return;
				}
			}
			if (check(ny, nx)) {
				if (count[map[ny][nx]] == 0) {
					dfs(ny, nx, i, dep + 1, count);
				}
			}
		}
		count[map[y][x]] = 0;

	}

	static int change(String s) {
		return Integer.parseInt(s);
	}

	static boolean check(int y, int x) {
		if (y < N && y >= 0 && x < N && x >= 0) {
			return true;
		}
		return false;
	}
}
