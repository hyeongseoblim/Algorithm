import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.zip.InflaterInputStream;

public class Solution_핀볼게임 {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;
	static int N;
	static ArrayList<int[]> whiteho;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int Test = 1; Test <= T; Test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			whiteho = new ArrayList<>();
			StringTokenizer st = null;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] >= 6) {
						whiteho.add(new int[] { i, j, map[i][j] });
					}
				}
			}
			int count = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						for (int k = 0; k < 4; k++) {
							count = Math.max(count, bfs(i, j, k));
						}
					}
				}
			}
			if (count == Integer.MIN_VALUE)
				count = 0;
			System.out.println("#" + Test + " " + count);
		}

	}

	private static int bfs(int y, int x, int k) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { y, x, k });
		int max = Integer.MIN_VALUE;

		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int[] now = que.poll();
				int cy = now[0];
				int cx = now[1];
				if (now.length == 3) {
					int ny = cy + dy[k];
					int nx = cx + dx[k];
					que.add(new int[] { ny, nx, k, 0 });
				} else {
					if (cy == y && cx == x) {
						max = Math.max(max, now[3]);
						return max;
					}
					if (!check(cy, cx)) {
						int[] next = reverse(now);
						que.add(next);
					} else {
						if (map[cy][cx] == -1) {
							max = Math.max(max, now[3]);
							return max;
						}

						int ny = cy + dy[now[2]];
						int nx = cx + dx[now[2]];
						if (map[cy][cx] == 0) {
							que.add(new int[] { ny, nx, now[2], now[3] });
						} else if (map[cy][cx] == 1) {
							// 1 아래 -> 오른쪽 / 왼쪽->위 1 - 3 / 2 - 0
							if (now[2] == 1) {
								now[2] = 3;
								ny = cy + dy[3];
								nx = cx + dx[3];
								que.add(new int[] { ny, nx, now[2], ++now[3] });
							} else if (now[2] == 2) {
								now[2] = 0;
								ny = cy + dy[0];
								nx = cx + dx[0];
								que.add(new int[] { ny, nx, now[2], ++now[3] });
							} else {
								int[] next = reverse(now);
								que.add(next);
							}
						} else if (map[cy][cx] == 2) {
							// 2 왼쪽 -> 아래 / 위 -> 오른쪽 2 - 1 / 0 - 3
							if (now[2] == 2) {
								now[2] = 1;
								ny = cy + dy[1];
								nx = cx + dx[1];
								que.add(new int[] { ny, nx, now[2], ++now[3] });
							} else if (now[2] == 0) {
								now[2] = 3;
								ny = cy + dy[3];
								nx = cx + dx[3];
								que.add(new int[] { ny, nx, now[2], ++now[3] });
							} else {
								int[] next = reverse(now);
								que.add(next);
							}
						} else if (map[cy][cx] == 3) {
							// 3 오른쪽 -> 아래/ 위 -> 왼쪽 3 - 1 / 0 - 2
							if (now[2] == 3) {
								now[2] = 1;
								ny = cy + dy[1];
								nx = cx + dx[1];
								que.add(new int[] { ny, nx, now[2], ++now[3] });
							} else if (now[2] == 0) {
								now[2] = 2;
								ny = cy + dy[2];
								nx = cx + dx[2];
								que.add(new int[] { ny, nx, now[2], ++now[3] });
							} else {
								int[] next = reverse(now);
								que.add(next);
							}
						} else if (map[cy][cx] == 4) {// 4 오른쪽 -> 위로 / 아래 ->왼쪽 3 - 0 / 1 - 2
							if (now[2] == 3) {
								now[2] = 0;
								ny = cy + dy[0];
								nx = cx + dx[0];
								que.add(new int[] { ny, nx, now[2], ++now[3] });
							} else if (now[2] == 1) {
								now[2] = 2;
								ny = cy + dy[2];
								nx = cx + dx[2];
								que.add(new int[] { ny, nx, now[2], ++now[3] });
							} else {
								int[] next = reverse(now);
								que.add(next);
							}
						} else if (map[cy][cx] == 5) {
							int[] next = reverse(now);
							que.add(next);
						} else {
							// 6~10 웜홀 같은 위치 웜홀로 -1 블랙홀 게임종료
							for (int[] js : whiteho) {
								int[] next = js;
								if ((next[0] != cy || next[1] != cx) && next[2] == map[cy][cx]) {
									ny = next[0] + dy[now[2]];
									nx = next[1] + dx[now[2]];
									que.add(new int[] { ny, nx, now[2], now[3] });
								}
							}
						}

					}
				}
			}

		}
		return max;

	}

	private static boolean check(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < N)
			return true;
		return false;
	}

	private static int[] reverse(int[] now) {
		int ny = now[0] - dy[now[2]];
		int nx = now[1] - dx[now[2]];
		if (now[2] % 2 == 0) {
			return (new int[] { ny, nx, now[2] + 1, ++now[3] });
		} else {
			return (new int[] { ny, nx, now[2] - 1, ++now[3] });
		}
	}
}