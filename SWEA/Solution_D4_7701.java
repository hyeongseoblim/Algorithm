package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;

public class Solution_D4_7701 {
	static int T;


	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			boolean[] check = new boolean[51];
			LinkedList<String> list = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {// 입력 받는 부분
				String temp = br.readLine();
				check[temp.length()] = true;
				list.add(temp);
			}
			Collections.sort(list);// 길ㅇ

			bw.write("#" + test+"\n");
			String tmp = null;
			for (int i = 1; i < check.length; i++) {
				if (list.isEmpty())
					break;
				if (check[i]) {
					int size = list.size();
					for (int j = 0; j < size; j++) {
						String temp = list.get(j);
						if (temp.length() != i || temp.equals(tmp))
							continue;
						bw.write(temp+"\n");
						tmp = temp;
						list.remove(j);
						size--;
						j--;
					}

				}
			}
		}
		bw.flush();

		bw.close();
	}

}
