import java.io.*;
import java.util.Arrays;

public class Main_1181 {
    static class word implements Comparable<word> {
        private String word;
        private int length;

        public word(String word, int length) {
            this.word = word;
            this.length = length;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        @Override
        public int compareTo(word o) {
            if (this.getLength() < o.getLength()) {
                return -1;
            } else if (this.getLength() == o.getLength()) {
                for (int i = 0; i < this.getLength(); i++) {
                    if (this.getWord().charAt(i) < o.getWord().charAt(i))
                        return -1;
                    else if(this.getWord().charAt(i)> o.getWord().charAt(i))
                        return 1;
                    else
                        continue;
                }
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        word[] arr = new word[n];
        for (int i = 0; i < arr.length; i++) {
            String words = br.readLine();
            arr[i] = new word(words, words.length());
        }
        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        String temp = arr[0].getWord();
        sb.append(temp).append("\n");
        for (int i = 1; i < arr.length; i++) {
            if (temp.equals(arr[i].getWord()))
                continue;
            else {
                temp = arr[i].getWord();
                sb.append(arr[i].getWord()).append("\n");

            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString().trim());
        bw.flush();
    }
}
