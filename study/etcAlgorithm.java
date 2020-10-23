import java.util.Arrays;

public class etcAlgorithm {
    static boolean[] prime = new boolean[1001];
    static int[] array;

    public static void main(String[] args) {
        System.out.println(isFrimeNumber(6));
        System.out.println(isFrimeNumber(7));
        Arrays.fill(prime, true);
        array = new int[]{1, 2, 3, 2, 5};
        eratos(30);
        for (int i = 2; i <= 30; i++) {
            if (prime[i])
                System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(twoPointer(5));
        System.out.println(Arrays.toString(sumarray(new int[]{1, 3, 5}, new int[]{2, 4, 6, 8})));
        System.out.println(arrangeSum(array,3,4));
    }

    static boolean isFrimeNumber(int x) {
        for (int i = 2; i <= (int) Math.sqrt(x) + 1; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    static void eratos(int n) {
        for (int i = 2; i < (int) Math.sqrt(n) + 1; i++) {
            if (prime[i] == true) {
                int j = 2;
                while (i * j <= n) {
                    prime[i * j] = false;
                    j += 1;
                }
            }
        }
    }

    static int twoPointer(int n) {
        int start = 0;
        int end = 0;
        int cnt = 0;
        int sum = 0;
        for (int i = start; i < array.length; i++) {
            while (sum < n && end < array.length) {
                sum += array[end];
                end += 1;
            }
            if (sum == n)
                cnt++;
            sum -= array[i];

        }
        return cnt;
    }

    static int[] sumarray(int[] arr1, int[] arr2) {
        int fistart = 0;
        int sestart = 0;
        int[] arr = new int[arr1.length + arr2.length];
        int idx = 0;
        while (fistart < arr1.length || sestart < arr2.length) {
            if (sestart >= arr2.length || (fistart < arr1.length && arr1[fistart] <= arr2[sestart])) {
                arr[idx] = arr1[fistart];
                fistart++;
            }else {
                arr[idx]=arr2[sestart];
                sestart++;
            }
            idx++;
        }

        return arr;
    }
    static int arrangeSum(int [] array, int left,int right){
        int sum =0;
        int [] prefixSum = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            prefixSum[i]=sum;
        }
        return prefixSum[right]-prefixSum[left-1];
    }



}
