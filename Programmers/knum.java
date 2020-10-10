import java.util.ArrayList;
import java.util.Arrays;

public class knum {
    public static void main(String[] args) {
        int[] temp = {1, 5, 2, 6, 3, 7, 4};
        int temps[][] = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        solution(temp, temps);
    }

    public static int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> temps = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            int a = commands[i][0] - 1;
            int b = commands[i][1];
            int c = commands[i][2] - 1;

            int[] temp = new int[b-a];

            System.arraycopy(array,a,temp,0,b-a);
            Arrays.sort(temp);
            temps.add(temp[c]);
        }
        int [] answer = new int[temps.size()];
        int idx =0;
        for (int a:temps) {
            answer[idx] = a;
            idx+=1;
        }
        return answer;
    }
}
