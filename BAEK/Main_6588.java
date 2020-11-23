package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_6588 {
    static boolean[] prime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 2; i < (int) Math.sqrt(1000000) + 1; i++) {
            if (!prime[i]) {
                for (int j = i * 2; j <= 1000000; j+=i) {
                    prime[j] = true;
                }
            }
        }
        while (true) {
            int t = Integer.parseInt(br.readLine());
            if (t == 0)
                break;
            String result = "";
            for (int i = 3; i < t; i+=2) {
                if (!prime[i] && !prime[t-i] && i%2==1 && (t-i)%2 ==1) {
                    result = t + " = " + i + " + " + (t-i);
                    break;
                }
            }
            if (result.equals(""))
                result = "Goldbach's conjecture is wrong.";

            System.out.println(result);
        }
    }

}
