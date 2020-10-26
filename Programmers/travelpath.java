import java.util.*;

public class travelpath {
    static HashMap<String, ArrayList<city>> list;
    static ArrayList<String> ans;
    static int n;

    static class city implements Comparable<city> {
        int visit;
        String name;

        public city(String name, int visit) {
            this.visit = visit;
            this.name = name;
        }

        @Override
        public int compareTo(city o) {
            if (this.name.charAt(0) < o.name.charAt(0))
                return -1;
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "A"}, {"A", "B"}, {"B", "A"}, {"A", "ICN"}, {"ICN", "A"}})));
    }

    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        list = new HashMap<>();
        ans = new ArrayList<>();

        for (int i = 0; i < tickets.length; i++) {
            if (list.containsKey(tickets[i][0])) {
                boolean isIt = false;
                int idx = 0;
                for (int j = 0; j < list.get(tickets[i][0]).size(); j++) {
                    if (list.get(tickets[i][0]).get(j).name.equals(tickets[i][1])) {
                        isIt = true;
                        idx = j;
                    }
                }
                if (isIt)
                    list.get(tickets[i][0]).get(idx).visit++;
                else
                    list.get(tickets[i][0]).add(new city(tickets[i][1], 1));
            } else {
                list.put(tickets[i][0], new ArrayList<>());
                list.get(tickets[i][0]).add(new city(tickets[i][1], 1));
            }
        }
        Set<String> keys = list.keySet();
        for (String key : keys) {
            Collections.sort(list.get(key));
        }
        n = tickets.length;
        dfs("ICN", 0, new ArrayList<>());

        answer = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }

    static void dfs(String key, int cnt, ArrayList<String> path) {
        if (cnt == n) {
            if (ans.size() < n + 1) {
                for (String s : path) {
                    ans.add(s);
                }
                ans.add(key);
            }
            return;
        }
        if (!list.containsKey(key))
            return;
        for (int i = 0; i < list.get(key).size(); i++) {
            if (list.get(key).get(i).visit >0) {
                list.get(key).get(i).visit-=1;
                path.add(key);
                dfs(list.get(key).get(i).name, cnt + 1, path);
                path.remove(path.size() - 1);
                list.get(key).get(i).visit+=1;
            }
        }
        return;
    }
}
