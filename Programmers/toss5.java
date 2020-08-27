import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class toss5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayList<Integer> lee = new ArrayList<>();
        ArrayList<Integer> kim = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input);
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens())
            lee.add(Integer.parseInt(st.nextToken()));
        input = br.readLine();
        st = new StringTokenizer(input);
        while (st.hasMoreTokens())
            kim.add(Integer.parseInt(st.nextToken()));
        ArrayList<Integer> res = new ArrayList<>();
        int leem = 0;
        int keem = 0;
        for (int i = 0; i < lee.size(); i++) {
            leem = lee.get(i);
            keem = kim.get(i);
            if (leem > keem)
                res.add(leem - keem);
            else {
                if (leem == keem);
                else {
                    if(i+1!=kim.size())
                    kim.set(i + 1, kim.get(i + 1) + (keem - leem));
                }
                res.add(0);
            }
        }
        for (int i: res) {
            sb.append(i+" ");
        }
        System.out.println(sb.toString().substring(0,sb.toString().length()-1));
    }
}