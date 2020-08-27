import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class toss6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println("Hello Goorm! Your input is " + input);
        StringTokenizer st = new StringTokenizer(input);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        int idx =0;
        while(st.hasMoreTokens()){
            String cur = st.nextToken();
            if(cur.contains(";")){
                list.get(idx).add(Integer.parseInt(cur.split("")[0]));
                idx++;
                list.add(new ArrayList<>());
                list.get(idx).add(Integer.parseInt(cur.split("")[2]));
            }else
                list.get(idx).add(Integer.parseInt(cur));
        }
        int []dy = {0,0,1,-1};
        int []dx = {1,-1,0,0};
        int cnt =0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if(list.get(i).get(j)==1){
                    for (int k = 0; k < 4; k++) {
                        if(list.get(i+dy[k]).get(j)==0)
                            cnt++;
                        if(list.get(i).get(j+dx[k])==0)
                            cnt++;
                    }
                }
            }
            System.out.println();
        }


    }
}