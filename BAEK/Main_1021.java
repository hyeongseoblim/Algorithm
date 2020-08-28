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
                for (int j = 1; j < size; j++) {
                    if(i==list.get(j)) {
                        if(size - j > size/2){
                            for (int k = 0; k < j; k++) {
                                list.add(list.pollFirst());
                                result+=1;
                            }
                            break;
                        }else{
                            for (int k = 0; k < size-j; k++) {
                                list.addFirst(list.pollLast());
                                result+=1;
                            }
                            break;
                        }
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
