import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LowerBound {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int [] dp = new int[n];
        int [] lower = new int[n];
        int len=0;
        lower[0]=arr[0];

        for (int i = 1; i <n; i++) {
            if(arr[i]>lower[len]){
                // 가장 끝에 담긴 수보다 현재 수가 큰 경우 증가 시키고 추가한다.
                len+=1;
                lower[len]=arr[i];
            }else{
                // 가장 끝에 담긴 수보다 현재 수가 작거나 같은 경우

                int sequence = binarysearch(arr[i], 0, len, lower);
                lower[sequence] = arr[i];
            }
        }
        System.out.println(Arrays.toString(lower)+" 최대길이 "+(len+1));
    }
    public static int binarysearch(int value, int left, int right, int[]arr){
        if(left>right)
            return left;
        int mid = (left+right)/2;

        if(arr[mid]==value)
            return mid;
        else if(arr[mid]>value){
            return binarysearch(value, left, mid-1,arr);
        }else
            return binarysearch(value, mid+1, right, arr);

    }
}
