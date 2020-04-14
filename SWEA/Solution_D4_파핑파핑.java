package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_파핑파핑 {
	static int T, N;
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static char[][] map;
	static int[][] countmap;
	static int[][] visited;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = change(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = change(br.readLine());
			count = 0;
			map = new char[N][N];
			countmap = new int[N][N];
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = temp[j];
				}
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == '.' && countmap[i][j] == 0) {
						for (int k = 0; k < 8; k++) {
							int ny = i + dy[k];
							int nx = j + dx[k];
							if (check(ny, nx) && map[ny][nx] == '*') {
								countmap[i][j]++;
							}
						}
					}
					if (map[i][j] == '*') {
						countmap[i][j] = -1;
					}
				}
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == '.' && countmap[i][j] == 0 && visited[i][j] == 0) {
						bfs(i, j);
						count++;
					}
				}
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (check(i, j) && countmap[i][j] > 0 && visited[i][j] == 0) {
						visited[i][j] = 1;
						count++;
					}
				}
			}
			System.out.println("#" + test + " " + count);
		}
	}

	static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void bfs(int y, int x) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { y, x });
		visited[y][x] = 1;
		while (!que.isEmpty()) {
			int size = que.size();

			for (int i = 0; i < size; i++) {
				int[] now = que.poll();
				int cy = now[0];
				int cx = now[1];

				for (int j = 0; j < 8; j++) {
					int ny = cy + dy[j];
					int nx = cx + dx[j];
					if (check(ny, nx) && countmap[ny][nx] == 0 && visited[ny][nx] == 0) {
						visited[ny][nx] = 1;
						que.offer(new int[] { ny, nx });
					} else if (check(ny, nx) && countmap[ny][nx] > 0 && visited[ny][nx] == 0) {
						visited[ny][nx] = 1;
					}

				}
			}
		}
	}

	static int change(String s) {
		return Integer.parseInt(s);
	}

	static boolean check(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < N) {
			return true;
		}
		return false;
	}
}
