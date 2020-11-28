package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10972 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = Integer.parseInt(st.nextToken());
        }
        int idx = n - 1;

        while (idx > 0 && prev[idx - 1] > prev[idx]) idx--;

        if (idx == 0) {

            System.out.println(-1);
        } else {

            int endIdx = n - 1;
            while (endIdx >= idx && prev[idx - 1] > prev[endIdx]) endIdx--;

            int iteration = n - 1 - endIdx;
            Arrays.sort(prev, idx - 1, prev.length);

            rightRotate(prev, idx - 1, idx + iteration);
            printArr(prev, n);
        }
    }

    static void printArr(int[] A, int N) {
        for (int i = 0; i < N; i++) {
            System.out.print(A[i] + " ");
        }
    }

    static void rightRotate(int[] A, int start, int end) {

        int last = A[end];

        for (int i = end; i > start; i--) {

            A[i] = A[i - 1];
        }

        A[start] = last;
    }

}
