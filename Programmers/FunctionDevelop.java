package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class FunctionDevelop {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        int[] b = {95, 90, 99, 99, 80, 99};
        int[] a = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(b,a)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] check = new boolean[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int cnt = 0;
            int res = 0;
            while (progresses[i] < 100) {
                cnt++;
                progresses[i] += speeds[i];
            }
            for (int j = i + 1; j < progresses.length; j++) {
                progresses[j] += speeds[j] * cnt;
            }
            int idx = i;
            while (progresses[idx] >= 100) {
                res++;
                i = idx;
                idx++;
                if (idx == progresses.length)
                    break;
            }
            list.add(res);
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
