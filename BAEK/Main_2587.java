package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2587 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int [] list = new int[5];
		int avg = 0;
		for (int i = 0; i < 5; i++) {
			list[i]=Integer.parseInt(br.readLine());
			avg+=list[i];
		}
		Arrays.sort(list);
		
		sb.append(avg/5+"\n"+list[2]);
		
		System.out.println(sb.toString());
		
	}
}
