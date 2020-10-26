import java.util.Scanner;

public class nhn_3 {
    static class people {
        char name;
        int num;

        public people(char name, int num) {
            this.name = name;
            this.num = num;
        }

        public people() {

        }
    }

    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
        people sul = new people('A', 1);
        people[] line = new people[numOfAllPlayers - 1];
        for (int i = 0; i < line.length; i++) {
            line[i] = new people((char) (66 + i), 0);
        }
        int idx = 0;
        for (int a : numOfMovesPerGame) {
            if(idx+a>=numOfAllPlayers){
                idx = idx+a-numOfAllPlayers+1;
            }else if(idx+a<0){
                idx = numOfAllPlayers-1+(idx+a);
            }else{
                idx +=a;
            }
            people now = line[idx];
            boolean flag = false;
            for (int i = 0; i < namesOfQuickPlayers.length; i++) {
                if (namesOfQuickPlayers[i] == now.name)
                    flag = true;
            }
            if (!flag) {
                people temp = new people();
                temp = now;
                line[idx] = sul;
                sul = temp;
                sul.num++;
            }
            else
                sul.num++;
        }

        for(people p:line)
    {
        System.out.println(p.name + " " + p.num);
    }
        System.out.println(sul.name+" "+sul.num);

}

private static class InputData {
    int numOfAllPlayers;
    int numOfQuickPlayers;
    char[] namesOfQuickPlayers;
    int numOfGames;
    int[] numOfMovesPerGame;
}

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
            System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

            inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.numOfMovesPerGame = new int[inputData.numOfGames];
            String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
            for (int i = 0; i < inputData.numOfGames; i++) {
                inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
    }

}
