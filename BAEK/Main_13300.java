package com.baek.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		// 남 1 여 0
		int[][] room = new int[6][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			room[grade - 1][sex]++;
		}
		int cnt = 0;
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				if (room[i][j] == 0)
					continue;
				else {
					cnt += room[i][j] / max;
					if (room[i][j] % max != 0)
						cnt++;
				}
			}
		}
		bw.append(String.valueOf(cnt));
		bw.flush();
		bw.close();
		br.close();
	}

}
