package com.ssafy.edu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_5658 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String[] list = br.readLine().split("");
			// 각변마다 덱
			Deque<String> first = new ArrayDeque<>();
			Deque<String> second = new ArrayDeque<>();
			Deque<String> third = new ArrayDeque<>();
			Deque<String> last = new ArrayDeque<>();
			// 초기값배열 돌리는 법 생성
			for (int i = 0; i < N / 4; i++) {
				first.add(list[i]);
				second.add(list[i + N / 4]);
				third.add(list[i + (N / 4) * 2]);
				last.add(list[i + (N / 4) * 3]);
			}
			TreeSet<Long> value = new TreeSet<Long>();
			// 초기와 같아질때 까지
			for (int i = 0; i <N/4; i++) {
				int pval = N/4-1; // 16^n 값구해주기 위함
				long result = 0; // 값구해주기
				for (Iterator iterator = first.iterator(); iterator.hasNext();) {
					long num = Long.parseLong((String) iterator.next(),16); // 16^n * 자리의 수
					result += (num * Math.pow(16, pval));// 더해서 값만들어주기
					pval--;
				}
				value.add(result);
				result = 0;
				pval = N/4-1;
				for (Iterator iterator = second.iterator(); iterator.hasNext();) {
					long num = Long.parseLong((String) iterator.next(),16);
					result += (num * Math.pow(16, pval));
					pval--;
				}
				value.add(result);
				result = 0;
				pval = N/4-1;
				for (Iterator iterator = third.iterator(); iterator.hasNext();) {
					long num = Long.parseLong((String) iterator.next(),16);
					result += (num * Math.pow(16, pval));
					pval--;
				}
				value.add(result);
				result = 0;
				pval = N/4-1;
				for (Iterator iterator = last.iterator(); iterator.hasNext();) {
					long num = Long.parseLong((String) iterator.next(),16);
					result += (num * Math.pow(16, pval));
					pval--;
				}
				value.add(result);

				first.addFirst(last.pollLast());
				second.addFirst(first.pollLast());
				third.addFirst(second.pollLast());
				last.addFirst(third.pollLast());
			}
			long ans =0;
			int cnt =0;
			
			for (Iterator iterator = value.descendingIterator(); iterator.hasNext();) {
				if(cnt==K) break;
				ans = (Long) iterator.next();
				cnt++;
			}
			System.out.println("#"+test+" "+ans);
			

		}
	}
}
