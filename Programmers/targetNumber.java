public class targetNumber {
    static int ans;

    public static void main(String[] args) {
        System.out.print(solution(new int[]{1,1,1,1,1},3));
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        ans = 0;
        dfs(0,0,target,numbers);
        answer= ans;
        return answer;
    }

    static void dfs(int cnt, int idx, int target, int[] numbers) {
        if (idx == numbers.length) {
            if (cnt == target) {
                ans++;
            }
            return;
        }
        cnt += numbers[idx];
        dfs(cnt, idx + 1, target, numbers);
        cnt -= numbers[idx] * 2;
        dfs(cnt, idx + 1, target, numbers);
    }
}
