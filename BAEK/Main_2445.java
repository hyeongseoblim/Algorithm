package com.baek.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2445 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(st.nextToken());
		
		String[][] map = new String[n*2-1][n*2];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				map[i][j]="*";
				map[i][n*2-j-1]="*";
			}
			for(int j = i+1; j<n*2-i-1; j++) {
				map[i][j]=" ";
			}
		}
		for (int i = 1; i < n; i++) {
			map[n-1+i]=map[n-1-i];
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				bw.append(map[i][j]);
			}
			bw.append("\n");
		}
	
		bw.flush();

		br.close();
		bw.close();
	}
}
