import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] num = new int[32001];
		ArrayList<Integer>[] list = new ArrayList[32001];
		for (int i = 0; i < list.length; i++) {
			list[i]= new ArrayList<>();
		}
		Queue<Integer> que = new LinkedList<>();
		int a = 0;
		int b = 0;
		for (int i = 0; i < c; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			num[b]++;
			list[a].add(b);
		}
		for (int i = 1; i <= N; i++) {
			if (num[i] == 0) {
				que.offer(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!que.isEmpty()) {
			int i = que.poll();
			sb.append(i).append(" ");
			for (int j = 0; j < list[i].size(); j++) {
				if (--num[list[i].get(j)] == 0)
					que.offer(list[i].get(j));
			}
		}
		System.out.println(sb.toString());
	}
}
