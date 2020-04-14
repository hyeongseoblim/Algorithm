package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_D4_3752 {
	static int T;
	static Set<Integer> set;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			LinkedList<Integer> score = new LinkedList<>();
			score.add(0);
			set = new HashSet<>();
			set.add(0);

			while (st.hasMoreTokens()) {
				score.add(Integer.parseInt(st.nextToken()));
			}

			for (int i = 0; i < score.size(); i++) {
				scoreSelect(score.get(i));
			}

			System.out.println("#" + test + " " + set.size());

		}
	}

	static void scoreSelect(int num) {
		Set<Integer> tmpSet = new HashSet<Integer>();
		tmpSet.addAll(set);
		Iterator<Integer> it = tmpSet.iterator();
		while (it.hasNext()) {
			set.add(it.next() + num);
		}
	}

}
