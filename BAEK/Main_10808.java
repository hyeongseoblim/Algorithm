import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10808 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] value = br.readLine().toCharArray();
		int [] alpa = new int[26];
		for (char c : value) {
			alpa[c-97]++;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(alpa[0]);
		for (int i = 1; i < alpa.length; i++) {
			sb.append(" "+alpa[i]);
		}
		System.out.println(sb.toString());
	}
}
