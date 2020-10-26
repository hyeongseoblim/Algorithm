public class network {
    static int[] list;

    public static void main(String[] args) {
        System.out.print(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.print(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));

    }

    public static int find(int a) {
        if (list[a] != a) {
            return find(list[a]);
        }
        return list[a];
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b)
            list[b] = a;
        else
            list[a] = b;
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = i;
        }
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if(i!=j && computers[i][j]==1){
                    union(i,j);
                }
            }
        }
        for (int i = 0; i < list.length; i++) {
            if(list[i]==i)
                answer++;
        }
        return answer;
    }


}
