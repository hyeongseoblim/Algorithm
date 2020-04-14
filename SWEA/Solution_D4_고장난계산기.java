package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_고장난계산기 {
	static int T, cnt;
	static int value;
	static int[] count;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			count = new int[10];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < count.length; i++) {
				count[i] = change(st.nextToken());
			}
			value = change(br.readLine());
			cnt = 0;
			flag = false;
			dfs();
			if (!flag)
				cnt = -1;

			System.out.println("#" + test + " " + cnt);

		}
	}

	private static void dfs() {

	} 

	static int change(String s) {
		return Integer.parseInt(s);
	}
}
