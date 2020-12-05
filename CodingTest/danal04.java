package CodingTest;

import java.util.*;

public class danal04 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{2, 1}, {1, 1}, {3, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 1}}, 2)));
        System.out.println(Arrays.toString(solution(new int[][]{{2, 1}, {1, 1}, {3, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 1}}, 1)));
    }

    public static int[] solution(int[][] customer, int K) {
        int[] answer = {};
        Set<String> line = new HashSet<>();
        Queue<String> delay = new LinkedList<>();
        for (int i = 0; i < customer.length; i++) {
            int cus = customer[i][0];
            int posi = customer[i][1];
            if (posi == 1)
                if (line.size() < K)
                    line.add(String.valueOf(cus));
                else
                    delay.offer(String.valueOf(cus));
            else {
                if (line.contains(String.valueOf(cus)))
                    line.remove(String.valueOf(cus));
                else if (delay.contains(String.valueOf(cus)))
                    delay.remove(String.valueOf(cus));
            }
            if (line.size() < K && !delay.isEmpty()) {
                for (int j = 0; j < K - line.size(); j++) {
                    line.add(delay.poll());
                }
            }

        }
        answer = new int[line.size()];
        int idx = 0;
        for (String s : line) {
            answer[idx] = Integer.parseInt(s);
            idx++;
        }
        Arrays.sort(answer);
        return answer;
    }
}
