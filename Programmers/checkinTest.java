public class checkinTest {
    public static void main(String[] args) {

        System.out.println(solution(6, new int[]{6, 10}));
        System.out.println(solution(6, new int[]{8,10}));
        System.out.println(solution(6, new int[]{4, 10}));
        System.out.println(solution(11, new int[]{3,4, 10}));
        System.out.println(solution(5, new int[]{1,1, 10}));
    }

    public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long min = 0;
        long max = 0;
        for (int s: times) {
            max=Math.max(s,max);
        }
        max *= n;
        while (min<=max) {
            long mid = (min + max) / 2;
            long count = 0;
            for (int i = 0; i < times.length; i++) {
                count += mid / times[i];
            }
            if (count >= n) {
                answer = Math.min(answer,mid);
                max=mid-1;
            } else  {
                min = mid+1;
            }

            mid = (min + max) / 2;

        }
        return answer;
    }

}
