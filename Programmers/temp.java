import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class temp {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"}})));
    }
    static boolean visit[];
    static List<String> list = new ArrayList<>();
    static String route = "";

    public static String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];

        for(int i = 0 ; i < tickets.length; i++) {

            String departure = tickets[i][0];
            String destination = tickets[i][1];

            if(departure.equals("ICN")) {
                visit[i] = true;
                route = departure + ",";
                dfs(tickets, destination, 1);
                visit[i] = false;
            }
        }

        Collections.sort(list);
        String[] answer = list.get(0).split(",");
        return answer;
    }

    public static void dfs(String[][] tickets, String end, int count) {

        route += end + ",";

        if(count==tickets.length) {
            list.add(route);
            return;
        }

        for(int i = 0 ; i < tickets.length ; i++) {
            String depart = tickets[i][0];
            String desti = tickets[i][1];

            if(end.equals(depart) && !visit[i]) {
                visit[i] = true;
                dfs(tickets, desti, count+1);
                visit[i] = false;
                route = route.substring(0, route.length()-4);
            }
        }
    }
}
