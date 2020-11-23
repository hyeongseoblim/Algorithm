package Programmers;

import java.util.Arrays;

public class blocks {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10,2)));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = {};
        int yheight = 0;
        int ywidth = 0;
        int height = 0;
        int width = 0;

        if (yellow == 1)
            answer = new int[]{3, 3};
        else {
            for (int i = 1; i <= yellow / 2; i++) {
                yheight=i;
                ywidth=yellow/i;
                height=yheight+2;
                width=ywidth+2;
                if(height*width-brown == yellow && width>height)
                    answer = new int[]{width,height};
            }
        }
        return answer;
    }
}

