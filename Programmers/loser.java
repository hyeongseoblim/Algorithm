import java.util.HashMap;
import java.util.Set;

public class loser {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"},new String[]{"kiki", "eden"}));
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer>  ans = new HashMap<>();
        for (String s: participant) {
            if(ans.containsKey(s)) {
                int temp =ans.get(s)+1;
                ans.put(s,temp);
            }
            else
                ans.put(s,1);
        }
        for (String s: completion) {
            if(ans.containsKey(s)) {
                int temp = ans.get(s) - 1;
                ans.put(s, temp);
            }
        }
        Set<String> keys = ans.keySet();
        for (String s: keys) {
            if(ans.get(s)==1)
                answer=s;
        }
        return answer;
    }
}
