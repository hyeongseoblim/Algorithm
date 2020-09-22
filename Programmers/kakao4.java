public class kakao4 {
    public static void main(String[] args) {



    }

    class Solution {
        public int solution(int n, int s, int a, int b, int[][] fares) {
            int answer = 0;
            int max = 100000000;
            int[][]map = new int[n+1][n+1];
            for (int i = 0; i <map.length ; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if(i==j)
                        map[i][j]=0;
                    else
                        map[i][j]=max;
                }
            }
            for (int i = 0; i < fares.length; i++) {
                map[fares[i][0]][fares[i][1]]=fares[i][2];
                map[fares[i][1]][fares[i][0]]=fares[i][2];
                }
            for (int i = 1; i < map.length; i++) {
                for (int j = 1; j < map.length; j++) {
                    for (int k = 1; k < map.length; k++) {
                        map[j][k]=Math.min(map[j][k],(map[j][i]+map[i][k]));
                    }
                }
            }
            answer = map[s][1]+map[s][a]+map[s][b];
            for (int i = 2; i <map.length; i++) {
                answer=Math.min(answer,map[s][i]+map[i][a]+map[i][b]);

            }

            return answer;
        }
    }
}

