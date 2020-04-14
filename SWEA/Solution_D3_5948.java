package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D3_5948 {
	static int T;
	static int[] nums;
	static int[] list;
	static int N = 3;
	static ArrayList<Integer> sol;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list = new int[7];
			nums = new int[N];
			sol = new ArrayList<>();
			int index = 0;
			while (st.hasMoreTokens()) {
				list[index] = Integer.parseInt(st.nextToken());
				index++;
			}
			combi(0, 0);
			sol.sort(Comparator.reverseOrder());
			
			System.out.println("#" + test + " "+sol.get(4));

		}
	}

	public static void combi(int start, int count) {
		if (count == N) {
			int value = 0;
			for (int i = 0; i < N; i++) {
				value += nums[i];
			}

			if (!sol.contains(value)) {
				sol.add(value);
			}
			return;
		}
		for (int i = start; i < list.length; i++) {
			nums[count] = list[i];
			combi(i + 1, count + 1);
		}
	}
}
