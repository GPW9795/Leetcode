package 排序;

import java.util.Arrays;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 6, 4, 0, 3};
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
