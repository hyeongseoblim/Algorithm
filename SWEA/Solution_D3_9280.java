package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_9280 {
	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);

			int[][] price = new int[n][2];

			int[] car = new int[m];

			for (int i = 0; i < price.length; i++) {
				price[i][0] = Integer.parseInt(br.readLine());
				price[i][1] = 0;
			}
			for (int i = 0; i < car.length; i++) {
				car[i] = Integer.parseInt(br.readLine());
			}

			int total = 0;
			int count = 0, count2 = 0;
			Queue<Integer> wait = new LinkedList<>();

			for (int i = 0; i < 2 * m; i++) {
				int temp = Integer.parseInt(br.readLine());
				if (temp > 0) {
					for (int j = 0; j < price.length; j++) {
						if (price[j][1] == 0) {
							price[j][1] = temp;
							if (count > 0)
								count = 0;
							break;
						} else {
							count++;
						}
					}
					if (count == price.length) {
						wait.offer(temp);
						count = 0;
					}

				} else {
					for (int j = 0; j < price.length; j++) {
						if (price[j][1] == Math.abs(temp)) {
							total += price[j][0] * car[Math.abs(temp) - 1];
							if (!wait.isEmpty()) {
								price[j][1] = wait.poll();
							} else
								price[j][1] = 0;

							if (count2 > 0)
								count2 = 0;
							break;
						} else {
							count2++;
						}
					}
					if (count2 == price.length) {
						wait.offer(temp);
						count2 = 0;
					}

				}
			}

			System.out.println("#" + test + " " + total);
		}
	}

}
