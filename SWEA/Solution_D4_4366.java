import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_D4_4366 {
	static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
		
			char[] two = br.readLine().toCharArray();
			char[] three = br.readLine().toCharArray();
			String t = String.valueOf(two);
			String th = String.valueOf(three);
			ArrayList<Integer> soltwo = new ArrayList<Integer>();
			ArrayList<Integer> solthree = new ArrayList<Integer>();
			soltwo.add(Integer.parseInt(t, 2));
			for (int i = two.length-1; i >=0; i--) {
				if (two[i] == '1') {
					two[i] = '0';
					if(String.valueOf(two)!=t)
					soltwo.add(Integer.parseInt(String.valueOf(two), 2));
					two[i] = '1';
				} else {
					two[i] = '1';
					if(String.valueOf(two)!=t)
					soltwo.add(Integer.parseInt(String.valueOf(two), 2));
					two[i] = '0';
				}
			}
			solthree.add(Integer.parseInt(th, 3));
			for (int i = three.length-1; i>=0; i--) {
				if (three[i] == '0') {
					three[i] = '1';
					if(String.valueOf(three)!=th)
					solthree.add(Integer.parseInt(String.valueOf(three), 3));
					three[i] = '2';
					if(String.valueOf(three)!=th)
					solthree.add(Integer.parseInt(String.valueOf(three), 3));
					three[i] = '0';
				} else if (three[i] == '1') {
					three[i] = '0';
					if(String.valueOf(three)!=th)
					solthree.add(Integer.parseInt(String.valueOf(three), 3));
					three[i] = '2';
					if(String.valueOf(three)!=th)
					solthree.add(Integer.parseInt(String.valueOf(three), 3));
					three[i] = '1';
				} else {
					three[i] = '0';
					if(String.valueOf(three)!=th)
					solthree.add(Integer.parseInt(String.valueOf(three), 3));
					three[i] = '1';
					if(String.valueOf(three)!=th)
					solthree.add(Integer.parseInt(String.valueOf(three), 3));
					three[i] = '2';
				}
			}
			int ans = 0;
			for (int thr : solthree) {
				for (int tw : soltwo) {
					if(thr == tw)
						ans=tw;
				}
			}
			System.out.println("#"+test+" "+ans);
		}
	}
}
