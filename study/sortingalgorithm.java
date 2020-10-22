import java.util.Arrays;

public class sortingalgorithm {
    public static void main(String[] args) {
        int[] array = {3, 5, 7, 8, 2, 1, 4, 7, 9, 0, 10, 22, 3, 123, 324, 456};

        int[] selarr = selection_sort(array);
        int[] insarr = insertion_sort(array);
        int[] quickarr = quick_sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(selarr));
        System.out.println(Arrays.toString(selarr));
        System.out.println(Arrays.toString(quickarr));

    }

    private static int[] selection_sort(int[] array) {
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
                array = swap(array, min, i);
            }
        }
        return array;
    }

    private static int[] insertion_sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    array = swap(array, j, j - 1);
                } else
                    break;
            }
        }
        return array;
    }

    private static int[] quick_sort(int[] array, int start, int end) {

        if (start >= end)
            return array;
        int pivot = start;
        int left = start + 1;
        int right = end;
        while (left <= right) {
            while (left <= end && array[left] <= array[pivot]) {
                left += 1;
            }
            while (right > start && array[right] >= array[pivot]) {
                right -= 1;
            }
            if (left > right) {
                array = swap(array, pivot, right);
            } else {
                array = swap(array, left, right);
            }
        }
        array = quick_sort(array, start, right - 1);
        array = quick_sort(array, right + 1, end);

        return array;
    }

    private static int[] swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        return arr;
    }
}
