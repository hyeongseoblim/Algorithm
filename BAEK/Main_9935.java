import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split("");
		String keyword = br.readLine();

		String temp = "";
		String temp2 ="";
		boolean flag = false;
		int idx = 0;
		while (!(line.length == 0)) {
			temp += line[idx];
			idx++;
			if (temp.length() == keyword.length()) {
				if (!temp.equals(keyword)) {
					temp2 += temp.substring(0,1);
					temp = temp.substring(1, temp.length());
				} else {
					flag = true;
					temp="";
				}
			}
			if (idx == line.length) {
				temp2+=temp;
				temp = "";
				if (flag) {
					idx =0;
					line = temp2.split("");
					temp2="";
					flag = false;
				} else {
					temp=temp2;
					break;
				}
			}
		}
		if (temp.length() == 0)
			temp = "FRULA";
		System.out.println(temp);
	}
}
