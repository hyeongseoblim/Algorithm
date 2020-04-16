import java.util.Scanner;

public class Main_2839 {
	static int kg1 = 3;
	// 3kg 봉지
	static int kg2 = 5;
	static int cnt;

	// 5kg 봉지
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Scanner 사용위한선언
		// 테스트 케이스 수
		// 테스트 케이스 만큼 반복
		int value = sc.nextInt();

		int cnt3 = 0;
		// 3으로 나눌때의 값을 선언
		int cnt5 = value / 5;
		// 5로 나눴을 때 몇번 나눠지는지
		value %= 5;
		// value를 5 나머지 연산 해준다.
		while (cnt5 >= 0) {// 5로 계속 나누면서 돌아준다.
			if (value % 3 == 0) {// 3 나머지 연산이 0인경우
				cnt3 = value / 3; // 3으로 나눈 값
				value %= 3;// 3으로 나머지연산 해준다.
				break;
			}
			cnt5--;// 횟수를 감소 시킨다. 5로 안나눠지면
			value += 5;// 5로 안나눠질 경우 +5

		}
		if (value == 0) { // 값이 5와 3으로 나눠지는 경우
			System.out.println(cnt5 + cnt3);
		} else// 안되는 경우
			System.out.println(-1);
	}

}