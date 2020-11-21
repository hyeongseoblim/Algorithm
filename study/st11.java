package study;

import java.util.Arrays;

public class st11 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,3,3,2,2,2,1}));
    }
    public static int solution(int[] A) {
        Arrays.sort(A);
        int[] arr = new int[100001];
        int max = 0;
        int min = 100000;
        for (int i = 0; i < A.length; i++) {
            arr[A[i]]++;
            min = Math.min(A[i],min);
            max = Math.max(A[i],max);
        }
        int result = 1;
        for(int i = max-1; i>=min; i--){
            if(arr[i]==2){
                arr[i]-=2;
                result+=2;
            }else if(arr[i]==1){
                arr[i]--;
                result++;
            }
        }

        return result;
    }
}
