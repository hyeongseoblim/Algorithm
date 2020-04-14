package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_6719 {
	static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			//입력 받는 부분
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[] list = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			// 정렬 -> 가장큰값들을 k개 만큼 가져오기 위해서
			Arrays.sort(list);
			
			double answer =0;
			for (int i = list.length-k; i <list.length; i--) {
				answer = (list[i]+answer)/2;
			}

			System.out.format("#" + test +" %.6f%n",answer);

		}
	}
}
