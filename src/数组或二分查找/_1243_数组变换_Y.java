package 数组或二分查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/array-transformation/
 */
public class _1243_数组变换_Y {
    public static List<Integer> transformArray(int[] arr) {
        int len = arr.length;
        boolean isChange = true;
        while (isChange) {
            isChange = false;
            int[] arrCopy = Arrays.copyOf(arr, len);
            for (int i = 1; i < len - 1; i++) {
                if (arrCopy[i] > arrCopy[i - 1] && arrCopy[i] > arrCopy[i + 1]) {
                    arr[i] -= 1;
                    isChange = true;
                }
                if (arrCopy[i] < arrCopy[i - 1] && arrCopy[i] < arrCopy[i + 1]) {
                    arr[i] += 1;
                    isChange = true;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 1, 1, 2, 2, 1};
        transformArray(arr);
    }
}
