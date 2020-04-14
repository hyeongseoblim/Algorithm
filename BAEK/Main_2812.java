import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2812 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[] line = br.readLine().toCharArray();
		Stack<Character> list = new Stack<>();
		
		int idx =1;
		int cnt =K;
		list.push(line[0]);
		while(cnt>0) {
			if(line[idx]>list.peek()) {
				list.pop();
				cnt--;
				while(cnt>0&&!list.isEmpty()&&list.peek()<line[idx]) {
				list.pop();
				cnt--;
				}
				list.push(line[idx]);
				idx++;
			}else {
				list.push(line[idx]);
				idx++;
			}
			if(idx<N&&cnt==0) {
				for (int i = idx; i < line.length; i++) {
					list.push(line[i]);
				}
			}
			if(idx==N) {
				while(cnt>0) {
					list.pop();
					cnt--;
				}
				break;
			}
			
			
			
		}
		StringBuilder sb = new StringBuilder();
		for (Character character : list) {
			sb.append(character);
		}
		System.out.println(sb.toString());
		

	}

}
