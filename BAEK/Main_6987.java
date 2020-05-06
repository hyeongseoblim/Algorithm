import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6987 {
	static boolean possible;
	static int[][] score;
	static int[][] game = { { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 },
			{ 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for (int i = 0; i < 4; i++) {
			score = new int[6][3];
			possible = false;
			st = new StringTokenizer(br.readLine(), " ");
			int sol = 0;
			for (int j = 0; j < score.length; j++) {
				sol += score[j][0] = Integer.parseInt(st.nextToken());
				sol += score[j][1] = Integer.parseInt(st.nextToken());
				sol += score[j][2] = Integer.parseInt(st.nextToken());
			}
			if(sol != 30)
				possible =false;
			else
				dfs(0);
			if(possible)
				sb.append(1+" ");
			else
				sb.append(0+" ");
		}
		System.out.println(sb.toString());
	}

	static void dfs(int round) {
		
		if (round == 15) {
			possible =true;
			return;
		}
		int f_team = game[0][round];
		int s_team = game[1][round];
		
		if(score[f_team][0]>0 && score[s_team][2]>0) {
			score[f_team][0]--;
			score[s_team][2]--;
			dfs(round+1);
			score[f_team][0]++;
			score[s_team][2]++;
		}
		if(score[f_team][2]>0 && score[s_team][0]>0) {
			score[f_team][2]--;
			score[s_team][0]--;
			dfs(round+1);
			score[f_team][2]++;
			score[s_team][0]++;
		}
		if(score[f_team][1]>0 && score[s_team][1]>0) {
			score[f_team][1]--;
			score[s_team][1]--;
			dfs(round+1);
			score[f_team][1]++;
			score[s_team][1]++;
		}
		
	}
}
