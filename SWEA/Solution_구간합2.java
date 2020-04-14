package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.print.attribute.HashAttributeSet;

public class Solution_구간합2 {
	static int T;
	static long A, B;
	static HashMap<Long, Long> m = new HashMap<Long, Long>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		m.clear();
		for (int i = 1; i < 17; i++) {
			long v = pow10(0L + i);
			m.put((v - 1L), h(v - 1L));
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {

			String[] temp = br.readLine().split(" ");
			A = Long.parseLong(temp[0]);
			B = Long.parseLong(temp[1]);
			Long sum = cal(B, A);
			System.out.println("#" + test + " " + sum);

		}

	}

	static long pow10(long l) {
		return (long) (Math.pow(10, l));
	}

	static long h(long n) {
		long len = Len(n) + 1L;
		return ((45L) * len * (1L + n)) / (10L);
	}

	static long e(long n) {
		return n * (n + 1L) / 2L;
	}

	static long cal(long b, long a) {
		if (a <= 1) {
			return f(b);
		} else if (a == b) {
			return f(b) - f(a - 1);
		} else {
			return f(b) - f(a - 1);
		}
	}

	private static Long f(long l) {
		if (m.containsKey(l)) {
			return m.get(l);
		} else if (l <= 9) {
			return e(l);
		} else {
			long v = pow10(Len(l));
			m.put(l, f(l - 1L - l % v) + g(l));
			return m.get(l);
		}
	}

	static long g(long l) {
		if (l <= 9) {
			return e(l);
		} else {
			long v = pow10(Len(l));
			return (l / v) * (l % v + 1L) + f(l % v);
		}
	}

	static long Len(long l) {
		return 0L + (l + "").length() - 1;
	}
}
