package CodingTest;

import java.util.*;

public class danal02 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"alex pizza pasta steak", "bob noodle sandwich pasta", "choi pizza sandwich pizza", "alex pizza pasta steak"})));
    }

    public static String[] solution(String[] orders) {
        String[] answer = {};
        HashMap<String, Set<String>> orderlist = new HashMap<>();
        StringTokenizer st = null;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < orders.length; i++) {
            st = new StringTokenizer(orders[i]);
            String key = st.nextToken();
            Set<String> temp = null;
            if (orderlist.containsKey(key))
                temp = orderlist.get(key);
            else
                temp = new HashSet<>();
            while (st.hasMoreTokens())
                temp.add(st.nextToken());
            max = Math.max(max, temp.size());
            orderlist.put(key, temp);
        }
        Set<String> keys = orderlist.keySet();
        ArrayList<String> ans = new ArrayList<>();
        for (String key : keys) {
            int size = orderlist.get(key).size();
            if (size == max)
                ans.add(key);
        }
        answer = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

}
