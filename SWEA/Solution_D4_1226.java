package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1226 {
	static int T;
	static int N = 16;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean flag;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test = 1; test <= 10; test++) {
			flag = false;
			map = new int[16][16];
			visited = new boolean[16][16];
			String aa = br.readLine();
			for (int i = 0; i < map.length; i++) {
				String[] temp = br.readLine().split("");
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(temp[j]);
				}
			}
			bfs(1, 1);

			if (flag == false) {
				System.out.println("#" + test + " " + 0);

			} else {
				System.out.println("#" + test + " " + 1);

			}

		}
	}

	private static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		int[] cu = { i, j };
		visited[i][j] = true;

		que.offer(cu);
		while (!que.isEmpty()) {
			int[] temp = que.poll();

			int y = temp[0];
			int x = temp[1];

			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if (check(ny, nx) && map[ny][nx] != 1 && visited[ny][nx] == false) {
					visited[ny][nx] = true;
					que.offer(new int[] { ny, nx });
					if (ny == 13 && nx == 13) {
						flag = true;
					}
				}
			}

		}

	}

	public static boolean check(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < N) {
			return true;
		} else {
			return false;
		}
	}
}
