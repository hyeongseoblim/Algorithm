import java.util.PriorityQueue;

public class morehot {
    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
        System.out.println(solution(new int[]{1, 2}, 7));

    }

    private static int solution(int[] scoville, int K) {
        int answer = 0;
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a: scoville) {
            pq.offer(a);
        }
        int val =0;
        while(true){
            val = pq.poll();
            if(val >= K) {
               pq.offer(val);
                break;
            }
            if(val < K && pq.size()==0){
                break;
            }
            val = val+pq.poll()*2;
            cnt++;
            pq.offer(val);
        }

        if (pq.size() == 0)
            answer = -1;
        else
            answer = cnt;
        return answer;
    }
}
