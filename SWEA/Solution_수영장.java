import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_수영장 {
	static int[] price;
	static int[] month;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			price = new int[4];
			month = new int[13];
			for (int i = 0; i < price.length; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < month.length; j++) {
				month[j] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			dfs(1, 0);
			if (min > price[3])
				min = price[3];
			System.out.println("#" + test + " " + min);
		}
	}

	static void dfs(int i, int sum) {
		if (i >= 13) {
			min = Math.min(min, sum);
			return;
		}
		if (month[i] != 0) {
			dfs(i + 1, sum + month[i] * price[0]);
			dfs(i + 1, sum + price[1]);
			dfs(i + 3, sum + price[2]);
		} else {
			dfs(i + 1, sum);
		}
	}
}
