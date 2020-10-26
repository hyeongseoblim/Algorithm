import java.util.Random;

public class lotto {
    static boolean visit[] = new boolean[46];
    public static void main(String[] args) {
        int cnt =0;
        while(cnt<6){
            Random r = new Random();
            int n = r.nextInt(46);
            if(n>0 && !visit[n]){
                cnt++;
                visit[n]=true;
            }
        }
        for (int i = 0; i < visit.length; i++) {
            if(visit[i])
                System.out.println(i);
        }
    }

}
