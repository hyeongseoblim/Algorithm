package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2490 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			cnt = 0;
			for (int j = 0; j < 4; j++) {
				int temp =Integer.parseInt(st.nextToken());
				if(temp == 1)
					cnt++;
			}
			if(cnt==0)
				sb.append("D"+"\n");
			else if(cnt ==1)
				sb.append("C"+"\n");
			else if (cnt == 2)
				sb.append("B"+"\n");
			else if (cnt == 3)
				sb.append("A"+"\n");
			else if (cnt == 4)
				sb.append("E"+"\n");
		}
		
		System.out.println(sb.substring(0,5));
	}
}
