import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_1138 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] line = new int[N + 1];
		int[] tall = new int[N + 1];
		for (int i = 1; i < line.length; i++) {
			line[i] = Integer.parseInt(st.nextToken());
			
		}
		int max=1;
		for (int i = 1; i < N+1; i++) {
			int idx = 1; 
			int idx2 = line[i];
			if(max!=1)
				idx=max+1;
			while (idx2 > 0) { 
				idx++;
				idx2--;
			}
			while (tall[idx] != 0) { 
				idx++;
			}
		    
			tall[idx] = i;
			if(line[i]==0)
				max=i;
		}

		for (int i = 1; i < tall.length; i++) {
			System.out.print(tall[i] + " ");
		}
	}
}
