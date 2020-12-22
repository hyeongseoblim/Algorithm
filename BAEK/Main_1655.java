package BAEK;

import java.beans.PropertyEditorSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int value = Integer.parseInt(br.readLine());
            if (min.size() == max.size())
                max.offer(value);
            else
                min.offer(value);
            if (min.size() != 0 && max.size() != 0) {
                if (max.peek() > min.peek()) {
                    int temp = min.poll();
                    max.offer(temp);
                    min.offer(max.poll());
                }
            }
                sb.append(max.peek() + "\n");
            }

        System.out.println(sb.toString().substring(0, sb.toString().length() - 1));
    }
}
