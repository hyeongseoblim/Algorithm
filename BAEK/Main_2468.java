import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468 {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;
	static int N;
	static boolean[][] visit;
	static boolean[][] visit2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		visit2 = new boolean[N][N];
		StringTokenizer st = null;
		int max = Integer.MIN_VALUE;
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		for (int cnt = 0; cnt <= max; cnt++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j])
						bfs(i, j, cnt);
				}
			}
			for (int i = 0; i < visit.length; i++) {
				visit2[i] = visit[i].clone();
			}
			int c = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit2[i][j]) {
						bfs2(i, j);
						c++;
					}
				}
			}
			ans = Math.max(ans, c);
		}
		System.out.println(ans);
	}

	private static void bfs2(int y, int x) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { y, x });
		visit2[y][x] = true;
		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int[] now = que.poll();
				int cy = now[0];
				int cx = now[1];
				for (int j = 0; j < 4; j++) {
					int ny = cy + dy[j];
					int nx = cx + dx[j];
					if (!check(ny, nx))
						continue;
					if (!visit2[ny][nx]) {
						visit2[ny][nx] = true;
						que.add(new int[] { ny, nx });
					}
				}
			}
		}
	}

	private static void bfs(int y, int x, int cnt) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { y, x });
		if (map[y][x] <= cnt)
			visit[y][x] = true;
		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int[] now = que.poll();
				int cy = now[0];
				int cx = now[1];
				for (int j = 0; j < 4; j++) {
					int ny = cy + dy[j];
					int nx = cx + dx[j];
					if (!check(ny, nx))
						continue;
					if (map[ny][nx] <= cnt && !visit[ny][nx]) {
						visit[ny][nx] = true;
						que.add(new int[] { ny, nx });
					}
				}
			}
		}

	}

	static boolean check(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < N)
			return true;
		return false;
	}
}