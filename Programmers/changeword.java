public class changeword {
    static int answer =1000;
    public static void main(String args[]) { // Test용
        String[] begin = {"hit", "hit", "hot"};
        String[] target = {"cog", "cog", "lot"};
        String[][] words = {{"hot", "dot", "dog", "lot", "log", "cog"}, {"hot", "dot", "dog", "lot", "log"}, {"hot", "dot", "dog", "lot", "log"}};
        // 4, 0, 1

        for (int i = 0; i < begin.length; i++) {
            System.out.println("answer : " + solution(begin[i], target[i], words[i]) + "\n");
        }
    }

    public static int solution(String begin, String target, String[] words) {
        boolean check = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target))
                check = true;
        }
        boolean[] flag = new boolean[words.length];
        if (!check)
            return 0;
        else
            dfs(begin, target,0,words,flag);

        return answer;
    }

    static void dfs(String begin, String target,int idx ,String[]words,boolean[]flag) {
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if(!flag[i]&&begin.charAt(j)!=words[i].charAt(j))
                    count++;
            }
            if(count == 1){
                if(target.equals(words[i])&&answer>idx+1){
                    answer = idx+1;
                    return;
                }
                flag[i]=true;
                dfs(words[i],target,idx+1,words,flag);
                flag[i]=false;
            }
        }

    }
}
