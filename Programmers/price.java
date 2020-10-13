
import java.util.Arrays;
import java.util.Stack;

public class price {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3})));
        System.out.println(Arrays.toString(solution(new int[]{3, 1})));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 5, 6, 10000, 9999, 4053, 2222, 5, 4, 3, 6, 7})));

    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > prices[i + 1]) {
                answer[i]=1;
                //stack.push();
            }
        }
        return answer;
    }
}
