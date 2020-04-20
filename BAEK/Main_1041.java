import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1041 {
	static long[] dice;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dice = new long[6];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < dice.length; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		long ans = 0L;
		if (N != 1) {
			dice[0] = Math.min(dice[0], dice[5]);
			dice[1] = Math.min(dice[1], dice[4]);
			dice[2] = Math.min(dice[2], dice[3]);
			long[] dice2 = { dice[0], dice[1], dice[2] };
			Arrays.sort(dice2);
			long min3 = dice2[0] + dice2[1] + dice2[2];
			long min2 = dice2[0] + dice2[1];
			long min1 = dice2[0];
			long total = (long) Math.pow(N, 2) * 5;
			ans += min3 * 4;
			total -= 12;
			ans += min2 * (4 * (2 * N - 3));
			total -= 8 * (2 * N - 3);
			ans += min1 * total;

		} else {
			Arrays.sort(dice);
			for (int i = 0; i < 5; i++) {
				ans += dice[i];
			}
		}
		System.out.println(ans);
	}

}
