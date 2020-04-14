package com.ssafy.edu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;


public class Solution5607조합 {
	static int mod = 1234567891;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			long ans = 1L;
			long [] pactorial = new long[N + 1];
			pactorial[0] = 1;
			for (int i = 1; i <= N; i++) {
				pactorial[i] = (i * pactorial[i - 1]) % mod;
			}
			long a = pactorial[R] * pactorial[N - R];
			a %= mod;
			long f= power(a,mod-2);
			ans=(pactorial[N]*f)%mod;
			System.out.println("#" + test + " " + ans);
		}
	}

	
	static long power(long x, long y) {
		long answ = 1L;
		while (y != 0) {
			if (y % 2 != 0) {
				answ *= x;
				answ%=mod;
			}
			x *= x;
			x%=mod;
			y /= 2;
		}
		return answ;
	}

}
