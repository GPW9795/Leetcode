package 排序;

import java.util.Arrays;

public class 快速排序 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int[] arr = {2, 5, 8, 5, 1, 7, 9, 0, 8};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] arr) {
        sort(arr, 0, arr.length);
        return arr;
    }

    public static void sort(int[] arr, int begin, int end) {
        if (end - begin < 2) return;
        int mid = quicksort(arr, begin, end);
        sort(arr, begin, mid);
        sort(arr, mid + 1, end);
    }

    public static int quicksort(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        end--;
        while (begin < end) {
            while (begin < end) {
                if (arr[end] < pivot) {
                    arr[begin++] = arr[end];
                    break;
                } else {
                    end--;
                }
            }
            while (begin < end) {
                if (arr[begin] > pivot) {
                    arr[end--] = arr[begin];
                    break;
                } else {
                    begin++;
                }
            }
        }
        arr[begin] = pivot;
        return begin;
    }
}
