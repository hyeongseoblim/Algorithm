package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1267 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] list = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < list.length; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int sum2 = 0;
		for (int val : list) {
			int temp = (val / 30);
			if (temp > 0)
				sum += (temp + 1) * 10;
			else
				sum += 10;
			temp = (val / 60);
			if (temp > 0)
				sum2 += (temp + 1) * 15;
			else
				sum2 += 15;

		}
		if (sum > sum2)
			sb.append("M " + sum2);
		else if (sum < sum2)
			sb.append("Y " + sum);
		else
			sb.append("Y M " + sum);
		System.out.println(sb.toString());

		// 영식 30초마다 10원 그미만 10원
		// 민식 60초마다 15원
	}
}
