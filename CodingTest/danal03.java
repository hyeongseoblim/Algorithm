package CodingTest;

public class danal03 {
        public int[] solution(int[] price) {
            int[] answer = new int[price.length];
            for(int i = 0; i<price.length; i++){
                boolean flag = false;
                for(int j= i+1; j<price.length; j++){
                    if(price[i]<price[j]){
                        answer[i]=j-i;
                        flag = true;
                        break;
                    }
                    if(!flag)
                        answer[i]=-1;
                }
            }
            answer[answer.length-1] = -1;
            return answer;
        }
}
