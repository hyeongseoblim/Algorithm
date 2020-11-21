package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16637 {
    static char[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        line = br.readLine().toCharArray();
        int max = 0;
        for (int i = 0; i < line.length; i += 2) {
            max = Math.max(solve(i, cal(0,i)), max);
        }
        System.out.println(max);
    }

    private static int cal(int start, int end) {
        int cnt = 0;
        int gi = -1;
        for (int i = start; i <= end; i++) {
            if ((int) line[i] >= 48 && (int) line[i] <= 57) {
                if (gi < 0)
                    cnt = (int) (line[i] - 48);
                else {
                    if (gi == 0)
                        cnt += (int) (line[i] - 48);
                    else if (gi == 1)
                        cnt -= (int) (line[i] - 48);
                    else
                        cnt *= (int) (line[i] - 48);
                }
            } else {
                switch (line[i]) {
                    case '+':
                        gi = 0;
                        break;
                    case '-':
                        gi = 1;
                        break;
                    case '*':
                        gi = 2;
                        break;
                }
            }
        }
        return cnt;
    }

    public static int solve(int idx, int value) {
        if (idx == line.length-1)
            return value;


        value = solve(idx+2,cal(idx,idx+2));

        return 0;
    }
}
