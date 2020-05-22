import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1113 {
	static int[][] map;
	static int N, M, max;
	static boolean[][] visit;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		Queue<int[]> que = new LinkedList<>();
		int min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j] - 48;
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		que = checking();
		int ans = bfs(que);
		System.out.println(ans);
	}

	static int bfs(Queue q) {
		Queue<int[]> que = q;
		int ans = 0;
		boolean flag = true;
		while (flag) {
			while (!que.isEmpty()) {
				int size = que.size();
				for (int i = 0; i < size; i++) {
					int now[] = que.poll();
					int cy = now[0];
					int cx = now[1];
					int cnt = 0;
					if (!check2(cy, cx))
						continue;
					for (int j = 0; j < 4; j++) {
						int ny = cy + dy[j];
						int nx = cy + dx[j];
						if (!check(ny, nx))
							continue;
						if (check3(ny,nx,cy,cx))
							cnt++;
					}
					if (cnt == 4) {
						map[cy][cx]++;
						ans++;
						que.add(new int[] { cy, cx });
					}
				}
				que = checking();

			}

			print();
			if (que.size() == 0)
				flag = false;
		}

		return ans;

	}

	static boolean check(int y, int x) {
		if (y > 0 && y < N && x > 0 && x < M)
			return true;
		return false;
	}

	static boolean check2(int y, int x) {
		if (map[y][x] == 0 || map[y][x] == max)
			return false;

		return true;
	}

	static boolean check3(int y, int x, int cy, int cx) {
		if (y == N - 1 || x == M - 1 || x == 0 || y == 0) {
			if (map[y][x] >= map[cy][cx]) {
				return true;
			} else {
				return false;
			}
		} else {
			if (max>= map[cy][cx]) {
				return true;
			} else {
				return false;
			}
		}
	}

	static Queue<int[]> checking() {
		Queue<int[]> que = new LinkedList<>();
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				int cnt = 0;
				if (!check2(i, j))
					continue;
				for (int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					if (!check(ny, nx))
						continue;
					if (map[ny][nx] >= map[i][j])
						cnt += 1;
				}
				if (cnt == 4) {
					que.add(new int[] { i, j });
				}
			}
		}
		return que;
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}
}
