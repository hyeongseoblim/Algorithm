package com.baek.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15552 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(st.nextToken());
		int first=0, second=0, sum=0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
			sum= first+second;
			bw.append(sum+"\n");
		}
		bw.flush();
		
		br.close();
		bw.close();
	}

}
