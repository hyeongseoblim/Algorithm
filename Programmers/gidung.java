package Programmers;

import java.util.ArrayList;
import java.util.Arrays;


public class gidung {
    public static void main(String[] args) {
////        int[][] arr = solution(5, new int[][]{{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}});
//            int [][] arr = solution(5, new int[][]{{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}});
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
        StringBuilder s = new StringBuilder("a");
        StringBuilder a = new StringBuilder("a");
        StringBuilder b = new StringBuilder("Spring");

        System.out.println(s.hashCode());

        System.out.println(a.hashCode());

        int b1 = b.hashCode();
        System.out.println(b1);
        }

}

     class Node implements Comparable<Node> {
        int y;
        int x;
        int stuff;

        public Node(int y, int x, int stuff) {
            this.y = y;
            this.x = x;
            this.stuff = stuff;
        }

        @Override
        public int compareTo(Node other) {
            if (this.x == other.x && this.y == other.y) {
                return Integer.compare(this.stuff, other.stuff);
            }
            if (this.x == other.x) {
                return Integer.compare(this.y, other.y);
            }
            return Integer.compare(this.x, other.x);
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public int getStuff() {
            return stuff;
        }
    }

//    public static int[][] solution(int n, int[][] build_frame) {
//        int[][] answer = {};
//        int[][] map = new int[n + 1][n + 1];
//        ArrayList<int[]> ans = new ArrayList<>();
//
//        for (int i = 0; i < build_frame.length; i++) {
//            int x = build_frame[i][0];
//            int y = build_frame[i][1];
//            int stuff= build_frame[i][2];
//            int operate = build_frame[i][3];
//            if(operate == 0){
//                if(ans.size()>0)
//                    ans.remove(new int[]{x,y,stuff});
//                if(!possible(new int[]{x,y,stuff}));
//
//            }else{
//
//            }
//        }
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < n + 1; j++) {
//                if (map[i][j] == 3) {
//                    ans.add(new int[]{i, j, 0});
//                } else if (map[i][j] == 4) {
//                    ans.add(new int[]{i, j, 1});
//                }
//            }
//        }
//
//        answer = new int[ans.size()][3];
//
//        return answer;
//    }
//
//    private static boolean possible(int[] ints) {
//    }

// 1 0 0 1 x y 구조물 종류 0=기둥 1=보 설치&삭제 삭제=0 설치=1