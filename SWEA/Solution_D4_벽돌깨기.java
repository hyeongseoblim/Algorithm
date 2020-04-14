package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_벽돌깨기 {
	static int T;
	static int H, W, N;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = change(st.nextToken());
			W = change(st.nextToken());
			H = change(st.nextToken());
			map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = change(st.nextToken());
				}
			}
			LinkedList<int[][]>list = new LinkedList<>();
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] != 0 && N>0) {
						bfs(i, j);
						N--;
					}
				}
			}

			System.out.println("#" + test + " ");

		}
	}

	private static void bfs(int i, int j) {
		int [][] temp = map.clone();
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { i, j });
		while(!que.isEmpty()) {
			int size = que.size();
			
			for (int k = 0; k < size; k++) {
				int [] now = que.poll();
				int cy= now[0];
				int cx= now[1];
				for (int l = 0; l < 4; l++) {
					int ny = cy+dy[l];
					int nx = cx+dx[l];
					if(!check(ny,nx))
						continue;
					else {
						if(temp[ny][nx]!=0) {
							
						}
					}
				}
			}
		}
		
	}
		

	static int change(String s) {
		return Integer.parseInt(s);
	}

	static boolean check(int y, int x) {
		if (y >= 0 && y < H && x >= 0 && x < W)
			return true;
		return false;
	}
}
