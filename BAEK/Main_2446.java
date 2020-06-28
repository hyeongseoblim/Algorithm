package com.baek.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2446 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(st.nextToken());
		String[][] map = new String[n * 2 - 1][n * 2 - 1];
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				map[i][j] = "*";
				map[i][n * 2 - 2 - j] = "*";
			}
			for(int j = 0; j<n; j++) {
				if(map[i][j]==null)
					map[i][j]=" ";
			}
		}
		for (int i = 0; i <= n - 2; i++) {
			map[n + i] = map[n - i - 2];
		}
		for (int i = 0; i < map.length; i++) {
			String temp ="";
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == null)
					continue;
				else
					temp+=(map[i][j]);
			}
			bw.append(temp);
			bw.append("\n");
		}

		bw.flush();

		br.close();
		bw.close();
	}
}
