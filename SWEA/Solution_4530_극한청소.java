import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4530_극한청소 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String[] s = st.nextToken().split("");
			String[] e = st.nextToken().split("");
			String temp1 = "";
			String temp2 = "";

			for (int i = 0; i < s.length; i++) {
				if (s[i].equals("-")) {
					temp1 += s[i];
				} else {
					int temp = Integer.parseInt(s[i]);
					if (temp > 4)
						temp1 += String.valueOf(temp - 1);
					else
						temp1 += String.valueOf(Math.abs(temp));
				}
			}
			for (int i = 0; i < e.length; i++) {
				if (e[i].equals("-")) {
					temp2 += e[i];
				} else {
					int temp = Integer.parseInt(e[i]);
					if (temp > 4)
						temp2 += String.valueOf(temp - 1);
					else
						temp2 += String.valueOf(temp);
				}
			}
			long a = Long.parseLong(temp1, 9);
			long b = Long.parseLong(temp2, 9);
			temp1 = String.valueOf(a);
			temp2 = String.valueOf(b);
			long start = Long.parseLong(temp1, 10);
			long end = Long.parseLong(temp2, 10);
			if ((start > 0 && end > 0) || (start < 0 && end < 0))
				System.out.println("#" + test + " " + (end - start));
			else
				System.out.println("#" + test + " " + (end - start - 1));
		}
	}

}
