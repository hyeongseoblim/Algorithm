import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_원자소멸 {
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int N, M;
	static int[][] map = new int[4001][4001];
	static int[] value;

	static class point {
		int y;
		int x;
		int d;
		int energy;
		int flag;

		public point(int y, int x, int d, int energy, int flag) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
			this.energy = energy;
			this.flag = flag;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = null;

			ArrayList<point> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = (1000 + Integer.parseInt(st.nextToken())) * 2;
				int y = 2 * (Integer.parseInt(st.nextToken()) + 1000);
				int d = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				list.add(new point(y, x, d, e, 1));
				map[y][x] = 1;

			}
			int ans = 0;
			int count = 4002;
			while (count > 0) {
				for (int k = 0; k < list.size(); k++) {
					if (list.get(k).flag < 1)
						continue;
					int ny = list.get(k).y + dy[list.get(k).d];
					int nx = list.get(k).x + dx[list.get(k).d];
					if (!check(ny, nx)) {
						map[list.get(k).y][list.get(k).x] = 0;
						list.set(k, new point(ny, nx, list.get(k).d, 0, -1));
					} else {
						if (map[ny][nx] == 1) {
							map[list.get(k).y][list.get(k).x] = 0;
							list.set(k, new point(ny, nx, list.get(k).d, list.get(k).energy, 0));
							for (int i = 0; i < list.size(); i++) {
								if ((list.get(i).x == nx && list.get(i).y == ny)
										|| (list.get(i).y + dy[list.get(i).d] == ny
												&& list.get(i).x + dx[list.get(i).d] == nx)) {
									if (list.get(i).y!= ny || list.get(i).x != nx) {
										map[list.get(i).y][list.get(i).x] = 0;}
									list.set(i, new point(ny, nx, list.get(i).d, list.get(i).energy, 0));
								}
							}
							map[ny][nx] = 0;
						} else {
							map[ny][nx] = 1;
							map[list.get(k).y][list.get(k).x] = 0;
							list.set(k, new point(ny, nx, list.get(k).d, list.get(k).energy, 1));
						}
					}
				}
				count--;
			}
			for (point point : list) {
				if (point.flag == 0) {
					ans += point.energy;
				}
			}
			System.out.println("#" + test + " " + ans);
		}

	}

	static boolean check(int y, int x) {
		if (y < 4001 && x < 4001 && x > 0 && y > 0)
			return true;
		return false;

	}
}
