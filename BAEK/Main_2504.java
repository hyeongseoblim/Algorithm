import java.io.*;
import java.util.Stack;

public class Main_2504 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] line = br.readLine().toCharArray();

        int result = solution(line);

        bw.append(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solution(char [] line) {
        Stack<String> stack = new Stack<>();
        int temp = 0;
        for (char c : line) {
            if (c == ')') {
                temp = 0;
                while (!stack.isEmpty()) {
                    if (stack.peek().equals("(")) {
                        stack.pop();
                        if (temp == 0) {
                            stack.push("2");
                        } else
                            stack.push(String.valueOf(2 * temp));
                        break;
                    } else if (stack.peek().equals("["))
                        return 0;
                    else {
                        if (temp == 0)
                            temp = Integer.parseInt(stack.pop());
                        else
                            temp += Integer.parseInt(stack.pop());
                    }
                }
            } else if (c == ']') {
                temp = 0;
                while (!stack.isEmpty()) {
                    if (stack.peek().equals("[")) {
                        stack.pop();
                        if (temp == 0) {
                            stack.push("3");
                        } else
                            stack.push(String.valueOf(3 * temp));
                        break;
                    } else if (stack.peek().equals("("))
                        return 0;
                    else {
                        if (temp == 0)
                            temp = Integer.parseInt(stack.pop());
                        else
                            temp += Integer.parseInt(stack.pop());
                    }
                }
            } else
                stack.push(String.valueOf(c));
        }
        int result = 0;
        while (!stack.isEmpty()) {
            if (stack.peek().equals("(") || stack.peek().equals("[")) {
                return 0;
            } else
                result += Integer.parseInt(stack.pop());
        }

        return result;
    }
}
