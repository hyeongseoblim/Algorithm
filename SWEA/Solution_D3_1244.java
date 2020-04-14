package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_1244 {
	static int T;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			String[] st = br.readLine().split("");
			LinkedList<Integer> list = new LinkedList<>();
			 count = 0;
			for (int i = 0; i < st.length; i++) {
				if (st[i].equals(" ")) {
					count = Integer.parseInt(st[i + 1]);
					break;
				} else {
					list.add(Integer.parseInt(st[i]));
				}
			}
			int cnt =0;
			
			for (int i = 0; i < list.size(); i++) {
				
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i));
			}

			System.out.println("#" + test + " " + sb.toString());
		}
	}
	static void dfs (int c) {
		if(c == count) {
			
		}
		return ;
	}
}
