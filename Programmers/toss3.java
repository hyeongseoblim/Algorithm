import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

class toss3 {
    public static void main(String[] args) throws Exception {
        // [!!주의!!] Function.compute 함수는 이미 구현되어있지만, 숨김처리되어 있습니다. 호출해서 테스트 해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        HashMap<Integer,Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(input);
        StringBuffer sb = new StringBuffer();
        int cur = 0;
//        int curValue = 0;
//        while(st.hasMoreTokens()){
//            cur = Integer.parseInt(st.nextToken());
//            if(map.get(cur)==null){
//                curValue=(compute(cur));
//                map.put(cur,curValue);
//                sb.append(curValue+" ");}
//            else
//                sb.append(map.get(cur)+" ");
//        }
//

        System.out.println(sb.toString().substring(0,sb.toString().length()-1));
    }
}