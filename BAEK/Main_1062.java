import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1062 {
	static boolean[] visit = new boolean[26];
	static int N, maxlength, ans;
	static ArrayList<char[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		maxlength = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			list.add(temp.replaceAll("[antic]", "").toCharArray());
		}
		ans = 0;
		visit['a' - 'a'] = true;
		visit['c' - 'a'] = true;
		visit['i' - 'a'] = true;
		visit['n' - 'a'] = true;
		visit['t' - 'a'] = true;

		if (maxlength < 5)
			System.out.print(0);
		else if (maxlength == 26)
			System.out.print(N);
		else {
			dfs(0, 5);
			System.out.println(ans);
		}
	}

	private static void dfs(int alp, int idx) {
		if (idx == maxlength) {
			int answ= 0;
			for (int i = 0; i < N; i++) {
				int temp = 0;
				boolean flag = true;
				char[] line = list.get(i);
				for (int j = 0; j < line.length; j++) {
					int aa = line[j]-'a';
					if (visit[line[j] - 'a'])
						temp++;
				}
				if (temp != line.length)
					flag = false;
				else
					answ += 1;
			}
			ans = Math.max(ans, answ);
			return;
		}
		for (int i = alp; i < visit.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(i, idx + 1);
				visit[i] = false;
			}
		}
	}
}
