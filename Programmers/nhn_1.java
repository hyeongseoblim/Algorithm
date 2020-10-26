import java.util.Scanner;
import java.util.Stack;

public class nhn_1 {
    private static void solution(int numOfOrder, String[] orderArr) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
        for (int i = 0; i < orderArr.length; i++) {
            String word = "";
            Stack<Character> line = new Stack<>();
            Stack<Character> words = new Stack<>();
            char[] temp = orderArr[i].toCharArray();
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == ')')
                    continue;
                else
                    line.push(temp[j]);
            }
            while (!line.isEmpty()) {
                char now = line.pop();
                if (now == 'R' || now == 'G' || now == 'B') {
                    words.push(now);
                } else if (now == '(') {
                    String temps = "";
                    char top = line.pop();

                    if (top == 'R' || top == 'G' || top == 'B') {
                        String tmp =String.valueOf(top);
                        if(line.size()>0) {
                            while (line.peek() == 'R' || line.peek() == 'G' || line.peek() == 'B') {
                                tmp = String.valueOf(line.pop()) + tmp;
                            }
                        }
                        if(words.size()>0) {
                            while (!words.isEmpty()) {
                                temps += (tmp + String.valueOf(words.pop()));
                            }
                            word = temps;
                        }else if(words.size()==0){
                            String[] tmps = word.split("");
                            word ="";
                            for (String s: tmps) {
                                word+=(tmp+s);
                            }
                        }
                    } else {
                        while (!words.isEmpty()) {
                            temps += (String.valueOf(words.pop()));
                        }
                        temps = temps + word;
                        word = "";
                        for (int j = 0; j < (int) top - 48; j++) {
                            word += temps;
                        }
                    }
                }
                else{
                    String temps ="";
                    while (!words.isEmpty()) {
                        temps += (String.valueOf(words.pop()));
                    }
                    String temp2 = temps;
                    temps = "";
                    for (int j = 0; j < (int) now - 48; j++) {
                        temps += temp2;
                    }
                    word = temps+word;
                }
            }
            if (!words.isEmpty()) {
                String temps = "";
                while (!words.isEmpty()) {
                    temps += String.valueOf(words.pop());
                }
                word = temps + word;
            }
            System.out.println(word);
        }
    }

    private static class InputData {
        int numOfOrder;
        String[] orderArr;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.orderArr = new String[inputData.numOfOrder];
            for (int i = 0; i < inputData.numOfOrder; i++) {
                inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfOrder, inputData.orderArr);
    }
}