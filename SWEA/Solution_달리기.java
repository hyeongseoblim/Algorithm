package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_달리기 {
	static int T, N ,sol;
	static int[] line, input;
	static long cnt;
	static boolean[] visited;
	static LinkedList<int[]> know;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			sol = Integer.parseInt(st.nextToken());
			line = new int[N];
			input = new int[N];
			for (int i = 0; i < N; i++) {
				input[i] = i + 1;
			}
			cnt = 0L;
			visited = new boolean[N];
			know = new LinkedList<>();
			for (int i = 0; i < sol; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				know.add(new int[] { first, second });
			}
			perm(0);

			System.out.println("#" + test + " " + cnt);
		}
	}

	static void perm(int count) {
		if (count == N) {
			boolean flag = true;
			for (int[] arr : know) {
				int f = arr[0];
				int s = arr[1];
				for (int i = 0; i < N - 1; i++) {
					if (line[i] == s && line[i + 1] == f)
						flag = false;
				}
			}
			if (flag) {
				cnt++;
				Arrays.toString(line);
			}
			return;

		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			line[count] = input[i];
			perm(count + 1);
			visited[i] = false;
		}
	}
}
