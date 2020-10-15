import java.util.ArrayList;
import java.util.Collections;

public class bigNumber {
    static boolean[] check;
    static ArrayList<String> tempans;
    static String ans;
    public static void main(String[] args) {
//        System.out.println(solution("1234",2));
        System.out.println(solution("1924",2));
        System.out.println(solution("1231234",3));
        System.out.println(solution("4177252841",4));
        System.out.println(solution("928857066163493066555730841879",7));
    }
    public static String solution(String number, int k) {
        StringBuffer sb = new StringBuffer();
        int n = number.length()-k;
        String [] num = number.split("");
        int [] nums = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            nums[i]=Integer.parseInt(num[i]);
        }
        int start = 0;
        int max = 0;
        for (int j = 0; j < n; j++) {
            max=0;
            for (int i = start; i <= k+j; i++) {
                if(max<nums[i]){
                    max= nums[i];
                    start = i+1;
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }

}
