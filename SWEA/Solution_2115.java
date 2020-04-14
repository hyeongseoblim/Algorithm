package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115 {
	static int T;
	static int N, M, C;
	static int[][] map;
	static int[][] cost;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = change(st.nextToken());
			M = change(st.nextToken());
			C = change(st.nextToken());
			map = new int[N][N];
			cost = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = change(st2.nextToken());
				}
			}
			makecost();// i j

			System.out.println("#" + test + " " + getMaxBenefit());

		}
	}

	private static int getMaxBenefit() {
		int max = 0;
		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {// a일꾼
				// 일꾼 B 선택 //1. 같은행기준
				for (int j2 = j + M; j2 <= N - M; j2++) {
					temp = cost[i][j] + cost[i][j2];
					if (max < temp) {
						max = temp;
					}
				}
				// 다음행부터
				for (int i2 = i + 1; i2 < N; i2++) {
					for (int j2 = 0; j2 <= N - M; j2++) {
						temp = cost[i][j] + cost[i2][j2];
						if (max < temp) {
							max = temp;
						}
					}
				}
			}
		}
		return max;

	}

	static void makecost() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				makeCostSubset(i, j, 0, 0, 0);
			}
		}
	}

	// y 행위치 x 열위치 cnt 고려한 원소수
	// sum 부분집합에 속한 원소의 합
	// powsum 부분집합에 속한 원소의 이익값
	static void makeCostSubset(int y, int x, int cnt, int sum, int powSum) {
		if (sum > C) {// 목표량 초과시 리턴
			return;
		}
		if (cnt == M) {
			// 0,0 M=3
			// 0,0 0,1 0,2
			if (cost[y][x - M] < powSum) {
				cost[y][x - M] = powSum;
			}
			return;
		}
		// select
		makeCostSubset(y, x + 1, cnt + 1, sum + map[y][x], powSum + map[y][x] * map[y][x]);
		// unselect
		makeCostSubset(y, x + 1, cnt + 1, sum, powSum);
	}

	static int change(String s) {
		return Integer.parseInt(s);
	}
}
