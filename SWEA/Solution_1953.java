package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1953 {
	static int T;
	static int day, month, month_3, year, min, month_count;
	static int[] list, cost, cost2;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			day = change(st.nextToken());
			month = change(st.nextToken());
			month_3 = change(st.nextToken());
			year = change(st.nextToken());
			month_count = 0;
			min=Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			list = new int[12];
			cost = new int[12];
			cost2 = new int[12];
			for (int i = 0; i < 12; i++) {
				list[i] = change(st.nextToken());
			}

			dfs(0, 0);
			int sol = min;
			if(sol>year) {
				sol = year;
			}
			System.out.println("#"+test+" "+sol);
		}
	}

	static void dfs(int i, int sum) {
		if (i >= cost.length) {
			min = Math.min(min, sum);
			return;
		}
		if (list[i] != 0) {
			dfs(i + 1, sum + list[i] * day);
			dfs(i + 1, sum + month);
			dfs(i + 3, sum + month_3);
		}else {
			dfs(i+1,sum);
		}
	}

	static int change(String s) {
		return Integer.parseInt(s);
	}
}
