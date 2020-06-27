package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2576 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 7; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (temp % 2 != 0) {
				if (min > temp)
					min = temp;
				sum += temp;
			}
		}
		if (sum != 0)
			sb.append(sum + "\n" + min);
		else
			sb.append(-1);
		System.out.println(sb.toString());

	}
}
