import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_10866 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer bw = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        LinkedList<String> list = new LinkedList<>();
        String temp ="";
        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(br.readLine());
            temp = st.nextToken();
            if(temp.equals("push_front")){
                if(list.size()==0)
                    list.add(st.nextToken());
                else
                    list.add(0,st.nextToken());
            }
            else if (temp.equals("push_back")){
                list.add(st.nextToken());
            }else if (temp.equals("pop_front")) {
                if (list.size() == 0)
                    bw.append("-1");
                else {
                    bw.append(list.get(0));
                    list.remove(0);
                }bw.append("\n");
            }else if (temp.equals("pop_back")){
                if (list.size() == 0)
                    bw.append("-1");
                else {
                    bw.append(list.get(list.size()-1));
                    list.remove(list.size()-1);
                }bw.append("\n");
            }else if (temp.equals("size")){
                bw.append(String.valueOf(list.size()));
                bw.append("\n");
            }else if (temp.equals("empty")){
                if(list.isEmpty())
                    bw.append("1");
                else
                    bw.append("0");
                bw.append("\n");
            }else if (temp.equals("front")){
                if(list.isEmpty())
                    bw.append("-1");
                else
                    bw.append(String.valueOf(list.get(0)));
                bw.append("\n");
            }else {
                if(list.isEmpty())
                    bw.append("-1");
                else
                    bw.append(String.valueOf(list.get(list.size()-1)));
                bw.append("\n");
            }
        }
        bw2.append(bw.toString().substring(0,bw.toString().length()-1));
        bw2.flush();
        bw2.close();
        br.close();
    }
}
