import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636 {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int N, M;
	static int[][] map;
	static int[][] map2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		map2 = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map2[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> que = new LinkedList<>();
		dfs(0, 0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					que.add(new int[] { i, j });
				}
			}
		}

		int ans = 0;
		int size = 0;
		while (!que.isEmpty()) {
			size = que.size();
			for (int i = 0; i < size; i++) {
				int[] now = que.poll();
				int cy = now[0];
				int cx = now[1];
				int cnt = 0;
				for (int j = 0; j < 4; j++) {
					int ny = cy + dy[j];
					int nx = cx + dx[j];
					if (!check(ny, nx))
						continue;
					if (map[ny][nx] < 2)
						cnt++;
				}
				if (cnt == 4) {
					que.add(new int[] { cy, cx });
				} else {
					map2[cy][cx] = 0;
				}
			}
			ans++;
			for (int i = 0; i < N; i++) {
				map[i] = map2[i].clone();
			}
			dfs(1, 1);
		}
		System.out.println(ans);
		System.out.println(size);

	}

	private static void dfs(int i, int j) {
		if (!check(i, j))
			return;
		if (map[i][j] == 0) {
			map[i][j] = 2;
			dfs(i + 1, j);
			dfs(i, j + 1);
			dfs(i - 1, j);
			dfs(i, j - 1);
		}
	}

	static boolean check(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < M)
			return true;
		return false;
	}

}
