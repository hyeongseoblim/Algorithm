import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_활주로건설 {
	static int X, N;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			int[][] map = new int[20][20];
			int[][] map2 = new int[20][20];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					map2[j][i] = map[i][j];
				}
			}
//			for (int i = 0; i < N + 2; i++) {
//				for (int j = 0; j < N + 2; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			int ans = 0;
			for (int i =0; i < N; i++) {
				if(dfs(map, i))
					ans++;
			}
			for (int i = 0; i < N; i++) {
				if(dfs(map2, i))
					ans++;
			}
			System.out.println("#" + test + " " + ans);
		}
	}

	private static boolean dfs(int[][] map, int idx) {
		int count = 1;
		int height = map[idx][0];

		for (int i = 1; i < N; i++) {
			if (height == map[idx][i]) {
				count++;
			} else if (map[idx][i] - height == 1) {
				if (count < X) {
					return false;
				} else {
					count = 1;
					height = map[idx][i];
				}
			} else if (height - map[idx][i] == 1) {
				if (N < X + i) {
					return false;
				}
				
				for (int j = 1; j < X; j++) {
					if (height - map[idx][++i] != 1) {
						return false;
					}
				}
				height = map[idx][i];
				count = 0;
			} else {
				return false;
			}
		}
		return true;
	}

	static boolean check(int y, int x) {
		if (y >= 0 && x >= 0 && y < N && x < N )
			return true;
		return false;
	}
}
