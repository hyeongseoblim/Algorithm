package com.baek.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10807 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int idx = 0;
		int[] list = new int[n];
		while (st.hasMoreTokens()) {
			list[idx] = Integer.parseInt(st.nextToken());
			idx++;
		}

		int se = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i : list) {
			if (i == se)
				cnt++;
		}

		bw.append(String.valueOf(cnt));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
