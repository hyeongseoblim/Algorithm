package Programmers;

import java.util.Arrays;

public class CountingBridge {
    public static void main(String[] args) {
        System.out.println(solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }

    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        answer = bs(distance, rocks, n);
        return answer;
    }

    public static int bs(int dist, int[] arr, int n) {
        int start = 0;
        int end = dist;
        int res = 0;

        while (start <= end) {
            int removerock = 0;
            int prev = 0;
            int mid = (start + end) / 2;
            int min =Integer.MAX_VALUE;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] - prev < mid)
                    removerock++;
                else {
                    min = Math.min(min,arr[i]-prev);
                    prev = arr[i];
                }
            }
            if (dist - prev < mid)
                removerock++;

            if (removerock > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
                if (removerock == n)
                    res = Math.max(res,min);
            }
        }
        return res;
    }
}
