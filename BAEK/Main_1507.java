import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1507 {
	static int ans, N;
	static int[][] adj;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		flag = false;
		StringTokenizer st = null;
		adj = new int[N][N];
		for (int i = 0; i < adj.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Arrays.fill(adj[i], 20000);
			for (int j = 0; j < adj.length; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = solve(adj);
		if (flag == false)
			System.out.println(ans);
		else
			System.out.println(-1);
	}

	static int solve(int[][] adj) {
		int[][] visited = new int[N][N];
		int [][] dp = new int [N][N];
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited.length; j++) {
				dp[i][j]=adj[i][j];
			}
		}
		int answ = 0;
		for (int k = 0; k < N; k++) { // 경유 정점
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) { // 도착정점
					if (i == j)
						continue;// 출발 정점
					if (k == j || i == k)
						continue;
					if (adj[i][j] > adj[i][k] + adj[k][j]) {
						flag = true;
					}
					if (adj[i][j] == adj[i][k] + adj[k][j]) {

						dp[i][j] = 0;
					}
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				if (dp[i][j] != 0) {
					answ += dp[i][j];
				}
			}
		}
		return answ / 2;
	}
}
