package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2562 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int max =0;
		int idx =0;
		for (int i = 0; i < 9; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp > max) {
				idx= i+1;
				max=temp;
			}
		}
		sb.append(max+"\n"+idx);
		System.out.println(sb.toString());
			
	}
}
