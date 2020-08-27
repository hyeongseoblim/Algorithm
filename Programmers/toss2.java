import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class toss2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean flag = true;
        ArrayList<Integer> num = new ArrayList<>();
        int[] list = new int[46];
        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            num.add(Integer.parseInt(st.nextToken()));
        }
        if (num.size() == 6) {
            int prev = num.get(0);
            list[prev]++;
            for (int i = 1; i < num.size(); i++) {
                if (num.get(i) < prev) {
                    flag = false;
                    break;
                } else {
                    if (list[num.get(i)] == 1) {
                        flag = false;
                        break;
                    } else
                        list[num.get(i)]++;
                }
            }
        } else
            flag = false;
        System.out.println(flag);
    }
}