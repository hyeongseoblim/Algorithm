package com.baek.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main_5397 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		LinkedList<Character> strline = new LinkedList<>();
		char[] list = null;
		int idx = 0;
		ListIterator<Character> li = null;
		for (int i = 0; i < n; i++) {
			strline.clear();

			st = new StringTokenizer(br.readLine());
			list = st.nextToken().toCharArray();
			for (int j = 0; j < list.length; j++) {
				if (strline.size() != 0) {
					if (list[j] - 60 == 0) {
						if (li.hasPrevious())
							li.previous();
					} else if (list[j] - 62 == 0) {
						if (li.hasNext())
							li.next();
					} else if (list[j] - 45 == 0) {
						if (li.hasPrevious()) {
							li.previous();
							li.remove();
						}
					} else
						li.add(list[j]);
				} else {
					if (list[j] == 45 || list[j] == 60 || list[j] == 62)
						continue;
					else
						strline.add(list[j]);
					idx = strline.size();
					li = strline.listIterator(idx);
				}
			}
			for (char c : strline) {
				bw.append(c);
			}
			bw.append("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
