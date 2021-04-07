package 排序;

import java.util.Arrays;

public class 归并排序 {
    private static int res;

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 1};
        int[] ref = new int[arr.length];
        merge(arr, ref, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(res);
    }

    public static void merge(int[] arr, int[] ref, int begin, int end) {
        if (begin >= end) return;
        int mid = (begin + end) >> 1;
        merge(arr, ref, begin, mid);
        merge(arr, ref, mid + 1, end);
        int l = begin, r = mid + 1;
        int i = begin;
        while (l <= mid && r <= end) {
            if (arr[l] < arr[r]) {
                ref[i++] = arr[l++];
            } else {
                res++;
                ref[i++] = arr[r++];
            }
        }
        while (l <= mid) {
            ref[i++] = arr[l++];
        }
        while (r <= end) {
            ref[i++] = arr[r++];
        }
        for (int j = begin; j <= end; j++) {
            arr[j] = ref[j];
        }
    }
}
