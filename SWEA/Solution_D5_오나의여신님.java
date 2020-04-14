package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D5_오나의여신님 {
	static int T;
	static int N, M, cnt;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static char[][] map;
	static int[][] count;
	static boolean[][] visited;
	static int sty, stx, endy, endx;
	static Queue<int[]> devil;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = change(st.nextToken());
			M = change(st.nextToken());
			cnt = 0;
			map = new char[N][M];
			count = new int[N][M];
			visited = new boolean[N][M];
			devil = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (temp[j] == 'D') {
						endy = i;
						endx = j;
					}
					if (temp[j] == 'S') {
						sty = i;
						stx = j;
					}
					if (temp[j] == '*') {
						devil.add(new int[] { i, j });
					}

					map[i][j] = temp[j];
				}
			}
			bfs(sty, stx);

			if (cnt == 0) {
				System.out.println("#" + test + " GAME OVER");

			} else
				System.out.println("#" + test + " " + count[endy][endx]);

		}
	}

	private static void bfs(int y, int x) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { y, x });
		visited[y][x] = true;
		while (true) {
			int size = que.size();
			int devil_size = devil.size();
			if (que.isEmpty()) {
				cnt = 0;
				return;
			}
			for (int i = 0; i < devil_size; i++) {
				int[] dnow = devil.poll();
				int dcy = dnow[0];
				int dcx = dnow[1];
				for (int j = 0; j < 4; j++) {
					int dny = dcy + dy[j];
					int dnx = dcx + dx[j];
					if (!check(dny, dnx)) {
						continue;
					} else {
						if (map[dny][dnx] == '.' || map[dny][dnx] == 'S') {
							map[dny][dnx] = '*';

							devil.add(new int[] { dny, dnx });
						} else
							continue;
					}
				}

			}
			for (int i = 0; i < size; i++) {
				int[] now = que.poll();
				int cy = now[0];
				int cx = now[1];
				for (int j = 0; j < 4; j++) {
					int ny = cy + dy[j];
					int nx = cx + dx[j];
					if (!check(ny, nx) || visited[ny][nx] == true)
						continue;
					else {
						if (map[ny][nx] == '.' || map[ny][nx] == 'D') {
							cnt++;
							count[ny][nx] = count[cy][cx] + 1;
							visited[ny][nx] = true;
							if (map[ny][nx] == '.') {
								map[ny][nx] = 'S';
								map[cy][cx] = '.';
								que.add(new int[] { ny, nx });
							} else {
								return;
							}
						} else {
							continue;
						}
					}
				}
			}

		}

	}

	static boolean check(int y, int x) {
		if (y >= 0 && y < N && x < M && x >= 0) {
			return true;
		}
		return false;
	}

	static int change(String s) {
		return Integer.parseInt(s);
	}
}
