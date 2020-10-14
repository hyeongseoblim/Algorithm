import java.util.ArrayList;
import java.util.Arrays;

public class pretest {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{4,4,4,5,1})));

    }

    public static int[] solution(int[] answers) {
        int[] answer = {};
        int first = 0;
        int second = 0;
        int third = 0;
        int[] fisrtAnswer = new int[10000];
        int[] secondAnswer = new int[10000];
        int[] thirdAnswer = new int[10000];
        int [] temp1 = {1,2,3,4,5};
        int [] temp2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int [] temp3 = {3,3,1,1,2,2,4,4,5,5};
        for (int i = 0; i < 2000; i+=5) {
            System.arraycopy(temp1, 0, fisrtAnswer, i, temp1.length);
        }
        for (int i = 0; i < 1250; i += 8) {
            System.arraycopy(temp2, 0, secondAnswer, i, temp2.length);
        }

        for (int i = 0; i < 1000; i += 10) {
            System.arraycopy(temp3, 0, thirdAnswer, i, temp3.length);
        }

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == fisrtAnswer[i])
                first += 1;
            if (answers[i] == secondAnswer[i])
                second += 1;
            if (answers[i] == thirdAnswer[i])
                third += 1;
        }
        int max = Math.max(first,Math.max(second,third));
        ArrayList<Integer> ans = new ArrayList<>();
        if(max == first)
            ans.add(1);
        if(max== second)
            ans.add(2);
        if(max==third)
            ans.add(3);
        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
