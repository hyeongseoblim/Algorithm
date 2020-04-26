import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_탈주범검거 {
	static int R, C, N, M, L;
	static int[][] pipe = { { 0, 1, 2, 3 }, { 0, 1 }, { 2, 3 }, { 0, 3 }, { 1, 3 }, { 1, 2 }, { 0, 2 } };
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0;
			ans = bfs(R, C, L);
			if (L == 1)
				ans = 1;

			System.out.println("#" + test + " " + ans);
		}
	}

	private static int bfs(int y, int x, int time) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { y, x });
		int count = time - 1;
		int cnt = 1;
		visited[y][x] = true;
		while (count != 0) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int[] now = que.poll();
				int cy = now[0];
				int cx = now[1];
				int pip = map[cy][cx];
				if (pip != 0) {
					for (int j = 0; j < pipe[pip - 1].length; j++) {
						int d = pipe[pip - 1][j];
						int ny = cy + dy[d];
						int nx = cx + dx[d];
						if (!check(ny, nx))
							continue;
						boolean flag = true;
						if (d == 0) {
							if (map[ny][nx] == 3 || map[ny][nx] == 4 || map[ny][nx] == 7)
								flag = false;
						} else if (d == 1) {
							if (map[ny][nx] == 3 || map[ny][nx] == 5 || map[ny][nx] == 6)
								flag = false;

						} else if (d == 2) {
							if (map[ny][nx] == 2 || map[ny][nx] == 7 || map[ny][nx] == 6)
								flag = false;

						} else if (d == 3) {
							if (map[ny][nx] == 2 || map[ny][nx] == 5 || map[ny][nx] == 4)
								flag = false;
						}
						if (flag && map[ny][nx] != 0 && !visited[ny][nx]) {
							if (pip == 2) {
								if (map[ny][nx] == 3)
									continue;
								visited[ny][nx] = true;
								cnt++;
								que.add(new int[] { ny, nx });
							} else if (pip == 3) {
								if (map[ny][nx] == 2)
									continue;
								visited[ny][nx] = true;
								cnt++;
								que.add(new int[] { ny, nx });
							} else {
								visited[ny][nx] = true;
								cnt++;
								que.add(new int[] { ny, nx });
							}
						} else
							continue;
					}
				}
			}
			count--;
		}
		return cnt;

	}

	static boolean check(int y, int x) {
		if (y >= 0 && x >= 0 && y < N && x < M)
			return true;
		return false;
	}
}
