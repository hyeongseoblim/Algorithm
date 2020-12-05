package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        char[] keyword = br.readLine().toCharArray();
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < line.length; i++) {
            stk.push(line[i]);
            if(stk.size()>=keyword.length){
                boolean flag = true;
                for (int j = 0; j < keyword.length; j++) {
                    if(keyword[keyword.length-1-j]!=stk.get(stk.size()-1-j)){
                        flag =false;
                        break;}
                }
                if(flag){
                    for (int j =0; j<keyword.length; j++) {
                        stk.pop();
                    }
                }
            }
        }
        if(stk.size()!=0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < stk.size(); i++) {
                sb.append(stk.get(i));
            }
            System.out.println(sb.toString());
        }else{
            System.out.println("FRULA");
        }
    }
}
