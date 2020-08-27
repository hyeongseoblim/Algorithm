import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            res.add(Integer.parseInt(st.nextToken()));
        }
        int result = 0;

        for (int i : res) {
            int size = list.size();
            if (i == list.get(0)) {
                list.remove(0);
            }
            else {
                if (Math.abs(list.get(0) - i) < Math.abs(list.get(size - 1) - i)) {
                    for (int j = 0; j < Math.abs(list.get(0) - i); j++) {
                        list.add(list.get(0));
                        list.remove(0);
                        result++;
                    }
                } else if (Math.abs(list.get(0) - i) > Math.abs(list.get(size - 1) - i)) {
                    for (int j = 0; j < Math.abs(list.get(size - 1) - i); j++) {
                        list.add(0, list.get(size - 1));
                        list.remove();

                        result++;
                    }
                }
                list.remove(0);
            }
        }
        bw.append(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }


}
