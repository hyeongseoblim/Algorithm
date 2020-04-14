package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_구간합 {
	static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			String [] temp = br.readLine().split(" ");
			Long A = Long.parseLong(temp[0]);
			Long B = Long.parseLong(temp[1]);
			long[] ans = new long[10];
			long point = 1;
			while (A <= B) {
				while (B % 10 != 9 && A <= B) {
					cal(B, ans, point);
					B--;
				}
				if (B < A) {
					break;
				}
				while (A % 10 != 0 && A <= B) {
					cal(A, ans, point);
					A++;
				}
				A /= 10;
				B /= 10;
				for (int i = 0; i < 10; i++) {
					ans[i] += (B - A + 1) * point;

				}
				point *= 10;
			}
			long sum = 0;
			for (int i = 0; i < ans.length; i++) {
				sum+=(ans[i]*i);
			}
			System.out.println("#" + test + " "+sum);

		}

	}

	private static void cal(Long b, long[] ans, long point) {
		while (b > 0) {
			String s = String.valueOf(b);
			int xx = s.charAt(s.length() - 1) - '0';
			ans[xx] += point;
			b /= 10;
		}
	}
}
