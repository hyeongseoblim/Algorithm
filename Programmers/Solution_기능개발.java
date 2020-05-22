import java.util.ArrayList;
import java.util.Arrays;

class Solution_기능개발 {
	static class process {
		int progresses;
		int speeds;

		process(int pro, int spd) {
			this.progresses = pro;
			this.speeds = spd;
		}

	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int len = progresses.length;
		ArrayList<process> list = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			list.add(new process(progresses[i], speeds[i]));
		}
		int cnt =0;
		while(!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				list.get(i).progresses+=list.get(i).speeds;
			}
			while(!list.isEmpty()&&list.get(0).progresses>=100) {
				cnt++;
				list.remove(0);
			}
			if(cnt >0) {
				result.add(cnt);
				cnt = 0;
			}
		}
		int [] answer = new int[result.size()];
		int idx =0;
		for (int i : result) {
			answer[idx]=i;
			idx++;
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] p = { 93, 30, 55 };
		int[] s = { 1, 30, 5 };
		System.out.println(Arrays.toString(solution(p,s)));
	}
}