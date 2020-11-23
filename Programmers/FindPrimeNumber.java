package Programmers;

import java.util.Arrays;
import java.util.HashSet;

public class FindPrimeNumber {
    static boolean[] prime = new boolean[10000001];
    static boolean[] check;
    static String[] arr;
    static HashSet<Integer> list;

    public static int solution(String numbers) {
        int answer = 0;
        Arrays.fill(prime, true);
        eratos(10000000);
        prime[0] = false;
        prime[1] = false;
        arr = numbers.split("");
        list = new HashSet<>();
        check = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Permutation(i + 1, 0, "");
        }
        for (int a : list) {
            if (prime[a])
                answer++;
        }
        return answer;
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

    private static void Permutation(int cnt, int idx, String val) {
        if (idx == cnt) {
            list.add(Integer.parseInt(val));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!check[i]) {
                check[i] = true;
                val += arr[i];
                Permutation(cnt, idx + 1, val);
                val = val.substring(0, val.length() - 1);
                check[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int a = solution("011");
        System.out.println(a);
    }
}
