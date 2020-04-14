package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1255 {
	static Queue<Integer> password;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test = 1; test <= 10; test++) {

			String num = br.readLine();
			String[] temp = br.readLine().split(" ");
			password = new LinkedList<>();

			for (String string : temp) {
				password.offer(Integer.parseInt(string));
			}
			System.out.println();
			int count = 1;
			while (true) {
				int peek = password.poll();
				if (count > 5)
					count = 1;
				peek -= count;
				if (peek <= 0) {
					peek = 0;
					password.offer(peek);
					break;
				}
				password.offer(peek);
				count++;
			}
			StringBuilder sb = new StringBuilder();
			while (!password.isEmpty()) {
				String temp2 = password.poll() % 10 + " ";
				sb.append(temp2);
			}

			System.out.println("#" + test + " " + sb.toString());
		}
	}

}
