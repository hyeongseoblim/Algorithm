package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1952 {
	static int T;
	static int day, month, month_3, year, sum, month_count;
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
			sum = 0;
			month_count = 0;

			st = new StringTokenizer(br.readLine(), " ");
			list = new int[12];
			cost = new int[12];
			cost2 = new int[12];
			for (int i = 0; i < 12; i++) {
				list[i] = change(st.nextToken());
			}
			for (int i = 0; i < list.length; i++) {
				if (list[i] != 0) {
					if (month < month_3) {
						if (list[i] * day < month) {
							cost[i] = list[i] * day;
						} else {
							cost[i] = month;
						}
					} else {
						if (list[i] * day < month_3) {
							cost[i] = list[i] * day;
						} else {
							cost[i] = month_3;
							i = i + 2;
						}
					}
				}
			}
			for (int i = 0; i < cost.length; i++) {
				if (cost[i] != 0) {
					dfs(i);
				}
			}
			for (int i = 0; i < cost2.length; i++) {
				if (cost2[i] > month_3 && cost[i] != 0) {
					cost[i] = month_3;
					cost[i + 1] = 0;
					cost[i + 2] = 0;
				}
			}
			int sum = 0;
			for (int i : cost) {
				if (i != 0)
					sum += i;
			}
			if (year < sum)
				sum = year;
			System.out.println("#" + test + " " + sum);

		}
	}

	static void dfs(int i) {
		if (i > cost.length) {
			return;
		}
		int temp = 0;
		if (i + 2 < cost.length) {
			temp = cost[i] + cost[i + 1] + cost[i + 2];
			cost2[i] = temp;
			dfs(i + 1);

		}

	}



	static int change(String s) {
		return Integer.parseInt(s);
	}
}
