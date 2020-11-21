package study;

import java.util.HashMap;
import java.util.Set;

public class st113 {

    public static void main(String[] args) {


        int [] a = {1,2,3,4,0};
        int [] b = {2,3,6,8,4};
        HashMap<Integer,Integer> ab = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0)
                continue;
            else {
                int now = b[i]/gcd(a[i],b[i]);

                if (ab.get(now) != null)
                    ab.put(now, ab.get(now) + 1);
                else
                    ab.put(now, 1);
            }
        }
        Set<Integer> keys = ab.keySet();

        int max = 1;
        for (double key: keys) {
            max = Math.max(max,ab.get(key));
        }

        System.out.println(max);

    }
    public static int gcd(int a,int b){
        int temp = 0;
        if(a<b){
            temp = a;
            a=b;
            b=temp;
        }
        int n =0;
        while(b!=0){
            n=a%b;
            a=b;
            b=n;
        }
        return a;
    }
}
