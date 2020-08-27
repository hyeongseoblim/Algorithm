import java.io.*;

class toss1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] list = input.toCharArray();
        boolean flag = true;

        int prev=list[0];

        for (int i = 1; i < list.length; i++) {
            if(prev=='1'){
                if(list[i]=='1') {
                    flag=false;
                    break;
                }else{
                    prev=list[i];
                }
            }else
                prev=list[i];
        }
        if(list[list.length-1]=='1')
            flag=false;
        System.out.println(flag);
    }
}