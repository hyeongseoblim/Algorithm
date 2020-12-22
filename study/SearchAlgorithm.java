package study;

import java.util.Arrays;

public class SearchAlgorithm {
    static class check {
        int value;
        boolean flag;

        public check(int value, boolean flag) {
            this.value = value;
            this.flag = flag;
        }

        @Override
        public String toString() {
            return "check{" +
                    "value=" + value +
                    ", flag=" + flag +
                    '}';
        }
    }

    public static void main(String[] args) {
        int array[] = {31, 53, 5, 6, 7, 4, 3, 54, 23, 34, 26, 7, 78, 2342, 213, 65, 24, 2332, 1, 23};
        Arrays.sort(array);
        System.out.println(recursionbinarySearch(array, 5, 0, array.length - 1));
        System.out.println(linearSearch(array, 5));
        System.out.println(iterbinarySearch(array, 5))
        ;
        System.out.println(recursionbinarySearch(array, 111, 0, array.length - 1));
        System.out.println(linearSearch(array, 111));
        System.out.println(iterbinarySearch(array, 111));

    }

    private static check linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target)
                return new check(i, true);
        }
        return new check(-1, false);
    }

    private static check recursionbinarySearch(int[] array, int target, int start, int end) {

        if (start > end)
            return new check(-1, false);
        int mid = (start + end) / 2;
        if (array[mid] == target)
            return new check(mid, true);
        else if (array[mid] > target)
            return recursionbinarySearch(array, target, start, mid - 1);
        else
            return recursionbinarySearch(array, target, mid + 1, end);
    }

    private static check iterbinarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == target)
                return new check(mid, true);
            else if (array[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return new check(-1, false);
    }
}
