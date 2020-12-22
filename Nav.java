import java.util.ArrayList;

public class Nav {
    static boolean[] check;
    public static void main(String[] args) {

        int idx =1;
        int d=4;
        for(int I=0; I<d; I++){
            if(I%2 == 0){
                for (int j = 0; j<d; j++){
                    System.out.print(idx);
                    idx++;
                }
            }
            else{
                for(int j = 0; j<d; j++){
                    System.out.print(idx);
                    idx --;
                }
            }
            System.out.println();
            idx+=d-1;
        }
    }

//    private static void combination(int start, int idx, int N, int R ,int[] x){
//        if(idx == R){
//            for (int i = 0; i < check.length; i++) {
//                if(check[i])
//                    System.out.print(x[i]+" ");
//            }
//            System.out.println();
//
//        }
//        for(int i = start; i<x.length; i++){
//            if(!check[i]){
//                check[i]=true;
//                combination(i+1, idx+1,N,R,x);
//                check[i]=false;
//            }
//        }
//    }

}
