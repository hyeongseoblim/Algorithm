package com.baek.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11328 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(st.nextToken());
		int[] alp = new int[26];
		int[] alp2 = new int[26];
		boolean check=false;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			char[] temp = st.nextToken().toCharArray();
			char[] temp2 = st.nextToken().toCharArray();
			alp=new int[26];
			alp2=new int[26];
			check=false;
			if (temp.length != temp2.length) {
				bw.append("Impossible");
			} else {
				for (int j = 0; j < temp.length; j++) {
					alp[temp[j] - 97]++;
					alp2[temp2[j] - 97]++;
				}
				for (int j = 0; j < alp.length; j++) {
					if(alp[j]==alp2[j])
						check=true;
					else {
						check=false;
						break;
					}
				}
				if(check)
					bw.append("Possible");
				else
					bw.append("Impossible");
			}
			bw.append("\n");
		}
		bw.flush();
		br.close();
		bw.close();
		
	}
}
