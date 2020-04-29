import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D4_4050_대관이 {
	static int T, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			Integer[] line = new Integer[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				line[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(line, Comparator.reverseOrder());
			int ans = 0;
			int div = N / 3;
			for (int i = 0; i < 3 * div; i += 3) {
				ans += line[i] + line[i + 1];
			}
			if (N % 3 != 0) {
				int idx = div * 3;
				for (int i = idx; i < N; i++) {
					ans += line[i];
				}
			}
			System.out.println("#" + test + " " + ans);

		}
	}
}
