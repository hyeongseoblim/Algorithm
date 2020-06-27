package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2480 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[3];
		list[0] = Integer.parseInt(st.nextToken());
		list[1] = Integer.parseInt(st.nextToken());
		list[2] = Integer.parseInt(st.nextToken());
		Arrays.sort(list);
		int max = list[0];
		int cnt = 1;

		for (int i = 1; i < list.length; i++) {
			if (list[i] == max)
				cnt++;
			if (list[i] > max && cnt < 2)
				max = list[i];
		}
		int money =0;
		switch(cnt) {
		case 1:
			money = max*100;
			break;
		case 2:
			money = max*100+1000;
			break;
		case 3:
			money = 10000+max*1000;
			break;
		}
		sb.append(money);
		
		System.out.println(sb.toString());
	}
}
