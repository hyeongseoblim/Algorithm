package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_4021 {
	static int T;
	static int[][] map;
	static int N;
	static int R;
	static LinkedList<Integer> list;
	static LinkedList<Integer> list2;
	static int[] nums;
	static int[] nums2;
	static boolean[] isGo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			R = N / 2;
			nums = new int[R];
			nums2 = new int[R];
			isGo = new boolean[N];
			map = new int[N][N];
			list = new LinkedList<>();
			list2 = new LinkedList<>();
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			combi(0, 0);
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < list.size(); i++) {
				int first = list.get(i);
				int second = list2.get(i);
				min = Math.min(min, Math.abs(first - second));
			}
			System.out.println("#" + test + " " + min);
		}
//		int[][] map2 = new int[N][];
//		map2[1] = new int[2];
//		map2[1][0] = 1;
//		map2[1][1] = 1;
//		for (int i = 2; i < map2.length; i++) {
//			map2[i] = new int[i + 1];
//			map2[i][0] = 1;
//			map2[i][i] = 1;
//			for (int j = 1; j < i; j++) {
//				map2[i][j] = map2[i - 1][j - 1] + map2[i - 1][j];
//			}
//
//		}
//		for (int i = 1; i < map2.length; i++) {
//			for (int j = 0; j < map2[i].length; j++) {
//				System.out.print(map2[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	public static void combi(int start, int count) {
		if (count == R) {
			int idx = 0;
			for (int i = 0; i < isGo.length; i++) {
				if (!isGo[i]) {
					nums2[idx] = i;
					idx++;
				}
			}

			int a = 0;
			int b = 0;
			for (int i = 0; i < nums.length; i++) {
				for (int j = 0; j < nums.length; j++) {
					if (i != j) {
						a += map[nums[i]][nums[j]];
						b += map[nums2[i]][nums2[j]];
					}
				}
			}

			list.add(a);
			list2.add(b);
			return;
		}

		for (int i = start; i < N; i++) {
			if (!isGo[i]) {
				isGo[i] = true;
				nums[count] = i;
				combi(i + 1, count + 1);
				isGo[i] = false;

			}
		}
	}
}
