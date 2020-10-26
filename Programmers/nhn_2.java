import java.util.Scanner;

public class nhn_2 {
    private static void solution(int day, int width, int[][] blocks) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
        int left, right;
        int[] line = new int[width];
        int answer=0;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                line[j] += blocks[i][j];
            }
            for (int j = 1; j < width - 1; j++) {
                left = right = 0;
                for (int k = 0; k < j; k++) {
                    left = Math.max(line[k], left);
                }
                for (int k = j + 1; k < width; k++) {
                    right = Math.max(line[k], right);
                }
                if (line[j] < left && line[j] < right) {
                    answer += Math.min(left, right) - line[j];
                    line[j]+=Math.min(left, right) - line[j];
                }
            }
        }
        System.out.print(answer);
    }

    private static class InputData {
        int day;
        int width;
        int[][] blocks;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.blocks = new int[inputData.day][inputData.width];
            for (int i = 0; i < inputData.day; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.width; j++) {
                    inputData.blocks[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.day, inputData.width, inputData.blocks);
    }
}
