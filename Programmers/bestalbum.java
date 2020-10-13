import java.util.*;

public class bestalbum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"},new int[]{500, 600, 150, 800, 2500})));
        System.out.println(Arrays.toString(solution(new String[]{"classic", "classic", "classic", "classic", "pop"},new int[]{500, 150, 800, 800, 2500})));

    }
    private static class genre implements Comparable<genre> {
        String name;
        public String getName() {
            return name;
        }
        int score;

        genre(String name, int score){
            this.name=name;
            this.score=score;
        }
        @Override
        public int compareTo(genre o) {
            return this.score-o.score;
        }
    }
    public static int[] solution(String[] genres, int[] plays) {

        HashMap<String, ArrayList<int[]>> ans = new HashMap<>();
        HashMap<String, Integer> rank = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if(ans.containsKey(genres[i])){
                ans.get(genres[i]).add(new int[]{plays[i],i});
                rank.put(genres[i],rank.get(genres[i])+plays[i]);
            }else{
                ArrayList<int[]> temp = new ArrayList<>();
                temp.add(new int[]{plays[i],i});
                ans.put(genres[i],temp);
                rank.put(genres[i],plays[i]);
            }
        }

        Set<String> rkeys = rank.keySet();
        ArrayList<genre> r = new ArrayList<>();
        for (String s: rkeys) {
            Collections.sort(ans.get(s),new Comparator<int[]>() {
                // Override된 compare 함수를 어떻게 정의하냐에 따라서 다양한 정렬이 가능해집니다
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });
            r.add(new genre(s,rank.get(s)));
        }
        Collections.sort(r,Comparator.reverseOrder());
        int idx =0;
        List<Integer> answ = new ArrayList<>();
        for (int i = 0; i < r.size(); i++) {
            ArrayList<int[]> temps = ans.get(r.get(i).getName());
            for (int a =0; a< temps.size(); a++) {
                if(a==2)
                    break;
                answ.add(temps.get(a)[1]);
                idx++;
            }
        }

        int [] answer = new int[answ.size()];
        for (int i = 0; i < answ.size(); i++) {
            answer[i] = answ.get(i);
        }

        return answer;
    }
}
