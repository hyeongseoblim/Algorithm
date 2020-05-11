import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2075 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = N * N - N;

		int[] map = new int[N * N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int k = i * N; k < (i + 1) * N; k++) {
				map[k] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(map);
		System.out.println(map[M]);

	}
}
