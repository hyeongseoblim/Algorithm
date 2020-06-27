package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10804 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int[] list = new int[20];
		for (int i = 0; i < list.length; i++) {
			list[i]=i+1;
		}
		for (int i = 0; i < 10; i++) {
			st= new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int mid = end-start;
			if(mid%2==0)
				mid=mid/2;
			else
				mid=mid/2+1;
			for (int j = 0; j <mid; j++) {
				int temp = list[start+j];
				list[start+j]=list[end-j];
				list[end-j]=temp;
			}
		}
		sb.append(list[0]);
		for (int i = 1; i < list.length; i++) {
			sb.append(" "+list[i]);
		}
		System.out.println(sb.toString());
		
	}
}
