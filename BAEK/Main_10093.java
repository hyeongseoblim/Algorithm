package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10093 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		long start = Long.parseLong(st.nextToken());
		long end = Long.parseLong(st.nextToken());
		if (start > end) {
			long temp = start;
			start = end;
			end = temp;
		}

		if (end - start <= 1) {
			sb.append(0);
			System.out.println(sb.toString());
		} else {
			sb.append(end - start - 1 + "\n");
			sb.append(start + 1);
			for (long i = start + 2; i < end; i++) {
				sb.append(" " + i);
			}
			System.out.println(sb.toString());
		}

	}
}
