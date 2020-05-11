import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] line = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}
		int end = 0;
		int cnt = 0;
		int sum = 0;
		for (int i = 0; i < N ; i++) {
			while (sum < M && end < N) {
				sum += line[end];
				end+=1;
			}
			if (sum == M) 
				cnt++;
			sum -= line[i];
		}

		System.out.println(cnt);
	}
}
