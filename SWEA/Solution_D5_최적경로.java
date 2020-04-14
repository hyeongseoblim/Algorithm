package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingDeque;

public class Solution_D5_최적경로 {
	static int T, N;
	static int stx, sty, homy, homx;
	static LinkedList<Point> list;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = change(br.readLine());
		for (int test = 1; test <= T; test++) {
			list = new LinkedList<>();
			N = change(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			sty = change(st.nextToken());
			stx = change(st.nextToken());
			homy = change(st.nextToken());
			homx = change(st.nextToken());
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int y = change(st.nextToken());
				int x = change(st.nextToken());
				list.add(new Point(y, x));
			}

			perm(0, 0, sty, stx, 0);
			System.out.println("#" + test + " " + min);

		}
	}

	static class Point {
		int y;
		int x;

		public Point(int y2, int x2) {
			this.y = y2;
			this.x = x2;
		}

	}

	static void perm(int flag, int count, int y, int x, int sum) {
		if (sum >= min)
			return;
		if (count == list.size()) {
			sum += Math.abs(x - homx) + Math.abs(y - homy);
			if (sum < min) {
				min = sum;
				return;
			}

		}
		for (int i = 0; i < list.size(); i++) {
			if ((flag & (1 << i)) == 0) {
				perm(flag | (1 << i), count + 1, list.get(i).y, list.get(i).x,
						sum + Math.abs(y - list.get(i).y) + Math.abs(x - list.get(i).x));
			}
		}

	}

	static int change(String s) {
		return Integer.parseInt(s);
	}
}
