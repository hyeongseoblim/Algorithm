package com.baek.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1919 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char [] flist = br.readLine().toCharArray();
		char [] slist = br.readLine().toCharArray();
		
		int [] alp = new int[26];
		int [] alp2 = new int[26];
		
		for (int i = 0; i < flist.length; i++) {
			alp[flist[i]-97]++;
		}
		for (int i = 0; i < slist.length; i++) {
			alp2[slist[i]-97]++;			
		}
		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			if(alp[i]!=alp2[i]) {
				if(alp[i]>alp2[i])
					cnt+=(alp[i]-alp2[i]);
				else
					cnt+=(alp2[i]-alp[i]);
			}else
				continue;
		}
		bw.append(String.valueOf(cnt));
		bw.flush();
		bw.close();
		br.close();
	}
}
