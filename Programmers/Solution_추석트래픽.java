import java.util.ArrayList;
import java.util.Collections;

public class Solution_추석트래픽 {

	static class work implements Comparable<work> {
		long first;
		long second;
		work(long a, long b) {
			this.first = a;
			this.second = b;
		}
		@Override
		public int compareTo(work p) {
			if (this.first > p.first) {
				return 1; // x에 대해서는 오름차순
			} else
				return -1;
		}
	}

	public static int solution(String[] lines) {
		ArrayList<work> run = new ArrayList<>();
		for (String string : lines) {
			String[] temp = string.split(" ");

			int hour = Integer.parseInt(temp[1].substring(0, 2)) * 3600*1000;
			int min = Integer.parseInt(temp[1].substring(3, 5)) * 60*1000;
			long etime = (long) (Double.parseDouble(temp[1].substring(6))*1000 + hour + min);
			long stime = (long) (etime - (Double.parseDouble(temp[2].replace("s", ""))*1000 - 1));
			run.add(new work(stime, etime)) ;
		}
		Collections.sort(run);//시작순서로 정렬
		int max = 0;
		int idx = 1;
		if (run.size() == 1)//작업하나의 경우처리
			return 1;
		for (int i = 0; i < run.size(); i++) {
			work now = run.get(i);
			for (int k = 0; k < 2; k++) {//현재꺼에서 시작, 마지막 꺼내와서 범위 세우기
				long st =0;
				if(k==0)st=now.first;
				else st=now.second;
				long end = st+999;
				for (int j = 0; j < run.size(); j++) {//같은 작업은 건너뛰고 작업마다 처리하기
					if (i == j)
						continue;
					work next = run.get(j);
					for (int l = 0; l < 2; l++) {//가져온작업 전후 비교 하나라도 카운팅시 다음작업으로 넘어가기
						long nct= 0;
						if (l==0)nct= next.first;
						else nct=next.second;
						if (end >= nct && st <= nct) {
							idx++;
							break;
						}
					}
				}
				max = Math.max(max, idx);
				idx = 1;
			}
		}

		int answer = max;

		return answer;
	}

	public static void main(String[] args) {
		String[] line = new String[] { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };
		String[] line2 = new String[] { "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s" };
		String[] line3 = new String[] { "2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s" };
		String[] line4 = new String[] { "2016-09-15 00:00:00.000 2.3s", "2016-09-15 23:59:59.999 0.1s" };

		System.out.println(solution(line));
		System.out.println(solution(line2));
		System.out.println(solution(line3));
		System.out.println(solution(line4));
	}
}