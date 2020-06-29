package com.baek.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		char list[] = br.readLine().toCharArray();
		LinkedList<String> words = new LinkedList<>();
		for (int i = 0; i < list.length; i++) {
			words.add(String.valueOf(list[i]));
		}
		int idx = words.size();
		ListIterator<String> li = words.listIterator(idx);
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String key = st.nextToken();
			if (key.equals("P")) {
				li.add(st.nextToken());
			} else if (key.equals("L")) {
				if (li.hasPrevious())
					li.previous();
			} else if (key.equals("D")) {
				if (li.hasNext())
					li.next();
			} else {
				if (li.hasPrevious()) {
					li.previous();
					li.remove();
				}
			}

		}

		for (String string : words) {
			bw.append(string);
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
