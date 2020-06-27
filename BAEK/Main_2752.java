package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2752 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] temp = br.readLine().split(" ");
		int [] list = new int [temp.length];
		for(int i =0 ; i<list.length; i++) {
			list[i]=Integer.parseInt(temp[i]);
		}
		Arrays.sort(list);
		
		sb.append(list[0]+" ");
		sb.append(list[1]+" ");
		sb.append(list[2]);
		System.out.println(sb.toString());
		
		
	}
}
