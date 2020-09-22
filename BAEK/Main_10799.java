import java.io.*;
import java.util.Stack;

public class Main_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] line = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        stack.push(line[0]);
        int result = 0;
        for (int i = 1; i < line.length; i++) {
            if (line[i] == '(')
                stack.push(line[i]);
            else {
                if (line[i - 1] == '(') {
                    stack.pop();
                    result += stack.size();
                } else {
                    stack.pop();
                    result += 1;
                }
            }
        }
        bw.append(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
