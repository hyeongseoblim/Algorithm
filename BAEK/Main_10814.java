import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10814 {
    static class user implements Comparable<user>{
        private int number;
        private String name;
        private int input;
        public user(int number, String name, int input) {
            this.number = number;
            this.name = name;
            this.input = input;
        }

        public int getInput() {
            return input;
        }

        public void setInput(int input) {
            this.input = input;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(user o) {
            if(this.getNumber()<o.getNumber()) {
                return -1;
            }else if(this.getNumber()==o.getNumber()){
                if(this.getInput()<o.getInput())
                    return -1;
            }
            return 1;
        }

        @Override
        public String toString() {
            return number +" "+name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        user [] arr = new user[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new user(Integer.parseInt(st.nextToken()),st.nextToken(),i);
        }
        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        for (user u:arr) {
            sb.append(u.toString()).append("\n");
        }
        bw.write(sb.toString().trim());
        bw.flush();
    }
}
