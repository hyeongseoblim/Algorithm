package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2309 {
	static int N = 9;
	static int R = 7;

	static int[] nums, list, mens;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		list = new int[N];
		nums = new int[R];
		mens = new int[R];
		for (int i = 0; i < list.length; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = Integer.parseInt(st.nextToken());
		}
		combi(0, 0);
		Arrays.sort(mens);
		sb.append(mens[0]);
		for (int i = 1; i < nums.length; i++) {
			sb.append("\n" +mens[i]);
		}
		
		System.out.println(sb.toString());

	}

	public static void combi(int start, int cnt) {
		if (cnt == R) {
			int sum = 0;
			for (int j = 0; j < nums.length; j++) {
				sum += nums[j];
			}
			if (sum == 100)
				mens = nums.clone();
			return;
		}
		for (int i = start; i < N; i++) {
			nums[cnt] = list[i];
			combi(i + 1, cnt + 1);
		}

	}
}
