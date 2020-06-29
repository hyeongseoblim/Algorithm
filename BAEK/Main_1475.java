package com.baek.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] list = br.readLine().toCharArray();
		int[] count = new int[9];
		for (int i = 0; i < list.length; i++) {
			if(list[i]-48 == 9)
				count[list[i]-51]++;
			else
				count[list[i]-48]++;
		}
		int temp = count[6]/2;
		if(count[6]%2!=0)
			count[6]=temp+1;
		else
			count[6]=temp;
		int max =Integer.MIN_VALUE;
		for (int i : count) {
			if(max<i)
				max=i;
		}
		bw.append(String.valueOf(max));
		bw.flush();
		bw.close();
		br.close();
	}

}
