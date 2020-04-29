import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class solution_줄기세포배양 {
	static int T, N, M, K;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;

	static class cell {
		int y;
		int x;
		int power;

		int lifetime;
		int deadtime;
		int flag;

		public cell(int y, int x, int power, int lifetime, int deadtime, int flag) {
			this.y = y;
			this.x = x;
			this.power = power;

			this.lifetime = lifetime;
			this.deadtime = deadtime;
			this.flag = flag;
		}

	}

	static List<ArrayList<cell>> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		list = new ArrayList<>();
		for (int test = 1; test <= T; test++) {
			list.clear();
			for (int i = 0; i <= 9; i++) {
				list.add(new ArrayList<>());
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N + K][M + K]; // 세로 + 배양, 가로 + 배양
			for (int i = (K / 2); i < N + (K / 2); i++) { // 배열의 중간을 계싼, k/2 k/2
				st = new StringTokenizer(br.readLine());
				for (int j = (K / 2); j < M + (K / 2); j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0) {
						int idx = map[i][j] - 1; // 리스트 작업시 0부터 9까지로
						list.get(idx).add(new cell(i, j, map[i][j], map[i][j], K, 0));
					}

				}

			}
			bfs();
			int cnt = 0;
			for (int i = 0; i < N + K; i++) {
				for (int j = 0; j < M + K; j++) {
					if (map[i][j] != 0 && map[i][j] != -1)
						cnt++;// (비활성화+활성화)상태 누적
				}
			}
			sb.append("#" + test + " " + cnt + "\n");
		}
		System.out.print(sb);
		br.close();

	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<cell> que = new LinkedList<cell>();
		for (int i = 9; i >= 0; i--) {
			if (list.get(i).size() != 0) {
				for (int j = 0; j < list.get(i).size(); j++) {
					que.offer(list.get(i).get(j));
				}
			}
		}
		while (!que.isEmpty()) {
			cell c = que.poll();
			if (c.lifetime == 0 && c.flag == 1) { // flag == 1 활성화 된 상태에서 생존기간 끝.
				map[c.y][c.x] = -1;// 죽은 세포 처리
				continue;
			}
			if (c.deadtime == 0)
				continue;// 배양시간 끝
			if (c.lifetime != 0) {// 비활성화, 활성화 상태 상관없이 다음 작업 수행.
				que.offer(new cell(c.y, c.x, c.power, c.lifetime - 1, c.deadtime - 1, c.flag));
				continue;// life, dead -1
			}
			que.offer(new cell(c.y, c.x, c.power, c.power, c.deadtime, 1));// 활성화 상태면 상하좌우 동시 번식
			for (int i = 0; i < 4; i++) {
				int ny = c.y + dy[i];
				int nx = c.x + dx[i];
				if (check(ny, nx) && map[ny][nx] == 0) {
					map[ny][nx] = c.power;
					que.offer(new cell(ny, nx, c.power, c.power, c.deadtime - 1, 0)); // 새로 번식된 세포는 비활성화 상태부터 시작
				}
			}
		}
	}

	static boolean check(int y, int x) {
		if (y >= 0 && y < N + K && x >= 0 && x < M + K)
			return true;
		return false;

	}
}
