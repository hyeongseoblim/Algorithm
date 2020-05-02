import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1949_등산로조성 {
	static int X, N, ans;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean visit[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visit = new boolean[N][N];
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			ans = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max)
						dfs(i, j, 1, false);
				}
			}
			sb.append("#" + test + " " + ans + "\n");
		}
		System.out.println(sb.toString());

	}

	static void dfs(int i, int j, int cnt, boolean use) {
		ans = Math.max(ans, cnt);
		visit[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int ny = i + dy[k];
			int nx = j + dx[k];
			if (!check(ny, nx) || visit[ny][nx])
				continue;
			if (map[i][j] > map[ny][nx]) {
				dfs(ny, nx, cnt + 1, use);
			} else {
				if (!use) {
					if (map[i][j] > map[ny][nx] - X) {
						int temp = map[ny][nx];
						map[ny][nx] = map[i][j] - 1;
						dfs(ny, nx, cnt + 1, true);
						map[ny][nx] = temp;
					}
				}
			}
		}
		visit[i][j] = false;
	}

	static boolean check(int y, int x) {
		if (y >= 0 && x >= 0 && y < N && x < N)
			return true;
		return false;
	}
}
