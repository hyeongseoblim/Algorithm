import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer bw = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        LinkedList<String> list = new LinkedList<>();
        String token = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            token = st.nextToken();
            if (token.equals("push")) {
                list.add(st.nextToken());
            } else if (token.equals("front")) {
                if (list.isEmpty())
                    bw.append("-1");
                else
                    bw.append(list.get(0));
                bw.append("\n");
            } else if (token.equals("pop")) {
                if (list.isEmpty()) {
                    bw.append("-1");
                } else {
                    bw.append(String.valueOf(list.get(0)));
                    list.remove(0);
                }
                bw.append("\n");
            } else if (token.equals("empty")) {
                if (list.isEmpty())
                    bw.append("1");
                else
                    bw.append("0");
                bw.append("\n");
            } else if (token.equals("size")) {
                bw.append(String.valueOf(list.size()));
                bw.append("\n");
            } else {
                if (list.isEmpty())
                    bw.append("-1");
                else
                    bw.append(list.get(list.size() - 1));
                bw.append("\n");
            }
        }
        System.out.println(bw.substring(0, bw.length() - 1));
        br.close();


    }
}
