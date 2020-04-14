package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_지도칠하기 {
	static int T, N,count;
	static int[] color, map_color;
	static int[][] map_count;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = change(br.readLine());
			color = new int[] { 1, 2, 3, 4 };
			map_color = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < map_color.length; i++) {
				map_color[i] = change(st.nextToken());
			}
			int[][] map = new int[N][N];
			map_count = new int[N][N];

			for (int i = 0; i < map.length; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
				Arrays.fill(map_count[i], -1);
				for (int j = 0; j < map.length; j++) {
					map[i][j] = change(st2.nextToken());
				}
			}
			 count = 0;
			for (int i = 0; i < map.length; i++) {
				int idx = 0;
				for (int j = 0; j < map.length; j++) {
					if (map[i][j] == 1) {
						map_count[i][idx] = j;
						idx++;
					}
				}
			}
			for (int i = 0; i < map.length; i++) {
				go(i,map_count[i]);
			}
			System.out.println("#" + test + " "+count);

		}
	}

	static void go(int start, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
				if (arr[i] != -1) {
					if (map_color[start] != map_color[arr[i]])
						continue;
					else {
						for (int j = 0; j < color.length; j++) {
							if (color[j] != map_color[start]) {
								map_color[arr[i]] = color[j];
								count ++;
								go(arr[i], map_count[arr[i]]);
							}
						}
					}
			}
		}

	}

	static int change(String s) {
		return Integer.parseInt(s);
	}
}
