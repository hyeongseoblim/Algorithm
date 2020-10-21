import java.util.*;

public class nhn_pretest {
    static int n;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    static int [][]map;
    private static void solution(int sizeOfMatrix, int[][] matrix) {
        // TODO: 이곳에 코드를 작성하세요.
        n = sizeOfMatrix;
        int cnt =0;
        map = new int[n][n];
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                map[i][j] = matrix[i][j];
                }
            }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(map[i][j]==1){
                    cnt++;
                    answer.add(bfs(i,j));
                }
            }
        }
        Collections.sort(answer);
        StringBuffer sb = new StringBuffer();
        sb.append(cnt+"\n");
        for (int a: answer){
            sb.append(a+" ");
        }
        System.out.print(sb.substring(0,sb.toString().length()-1));

    }
    private static boolean check(int y ,int x){
        if(y>=n|| x>=n || x<0 || y<0)
            return false;
        return true;
    }
    private static class InputData {
        int sizeOfMatrix;
        int[][] matrix;
    }
    private static int bfs(int y, int x){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int [] { y, x} );
        int cnt =1;
        map[y][x]=2;
        while(!que.isEmpty()){
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int [] now = que.poll();
                int cy = now[0];
                int cx = now[1];
                for (int j = 0; j < 4; j++) {
                    int ny = cy+dy[j];
                    int nx = cx+dx[j];
                    if(check(ny,nx)){
                        if(map[ny][nx]==1){
                            que.offer(new int[]{ny,nx});
                            map[ny][nx]=2;
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
            for (int i = 0; i < inputData.sizeOfMatrix; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.sizeOfMatrix; j++) {
                    inputData.matrix[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.sizeOfMatrix, inputData.matrix);
    }
}
