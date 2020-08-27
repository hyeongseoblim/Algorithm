import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class toss4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayList<String> stack = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input);
        StringBuilder sb = new StringBuilder();
        stack.add(st.nextToken());
        String temp = "";
        sb.append(stack.get(0)+"\n");
        while (st.hasMoreTokens()) {
            temp = st.nextToken();
            for (int i= 0; i<stack.size();i++) {
                if (stack.get(i).equals(temp)) {
                    stack.remove(i);
                    break;
                }
            }
            stack.add(0,temp);
            temp ="";
            if(stack.size()>5)
                stack.remove(5);
            for (int i= 0; i<stack.size();i++) {
                temp+=stack.get(i)+" ";
            }
            sb.append(temp.substring(0,temp.length()-1)+"\n");
        }
        System.out.println(sb.toString().substring(0,sb.toString().length()-1));
    }
}