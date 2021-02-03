import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static void bubbleSort(int[] arr) {
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
    }

    public static void main(String[] args) {
        int[] arr = {64, 6, 8, 2, 1, 7, 5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}