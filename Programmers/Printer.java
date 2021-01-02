package Programmers;

import java.util.*;

public class Printer {


    public static int solution(int[] priorities, int location) {
        int answer =1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int a:priorities) {
            pq.add(a);
        }
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location)
                        return answer;
                    pq.poll();
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int a = solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        int b = solution(new int[]{2, 1, 3, 2}, 2);
        System.out.println(solution(new int[]{1, 2, 3}, 0));
        System.out.println(a + " " + b);
    }
}
