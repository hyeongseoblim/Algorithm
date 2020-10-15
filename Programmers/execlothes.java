public class  execlothes {
    public static void main(String[] args) {
        System.out.println(solution(5,new int []{1,2,3,4,5},new int[]{1,3,5}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int [] student = new int [n];
        for (int i = 0; i < student.length; i++) {
            student[i]=1;
        }
        for (int i = 0; i < lost.length; i++) {
            student[lost[i]-1]--;
        }
        for (int i = 0; i < reserve.length; i++) {
            student[reserve[i]-1]++;
        }
        for (int i = 0; i < student.length; i++) {
            if(i == 0 && student[i]==0){
                if(student[i+1] == 2) {
                    student[i + 1]--;
                    student[i]++;
                }
            }
            else {
                if(i!=student.length-1) {
                    if (student[i] == 0) {
                        if (student[i - 1] == 2) {
                            student[i - 1]--;
                            student[i]++;
                        } else if (student[i + 1] == 2 && student[i - 1] != 2) {
                            student[i + 1]--;
                            student[i]++;
                        }
                    }
                }
                else{
                    if(student[i]==0){
                        if(student[i-1]==2){
                            student[i-1]--;
                            student[i]++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < student.length; i++) {
            if(student[i]>=1)
                answer++;
        }
        return answer;
    }
}
