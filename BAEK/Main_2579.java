import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[N + 1];
		stair[0] = 0;
		for (int i = 1; i < stair.length; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[N + 1];
		if (N > 1) {
			dp[0] = 0;
			dp[1] = stair[1];
			dp[2] = Math.max(stair[2], dp[1] + stair[2]);
			for (int i = 3; i < dp.length; i++) {
				dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i] + stair[i - 1]);
			}

			System.out.println(dp[N]);
		} else {
			System.out.println(stair[1]);
		}

	}
}
