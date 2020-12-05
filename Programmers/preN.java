package Programmers;

import java.util.ArrayList;

public class preN {
    public static void main(String[] args) {
        System.out.println(solution(5, 12));
    }

    public static int solution(int N, int number) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(new ArrayList<>());
        }
        if (N == number)
            return 1;
        String len = "1";
        list.get(0).add(N);
        dfs(list,len+"1");
        return answer;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> list, String s) {
    }
}
