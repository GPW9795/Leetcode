package 双指针;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class _977_有序数组的平方_Y {
    /**
     * 最简单的直接排序
     */
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }

    /**
     * 双指针
     */
    public static int[] sortedSquares1(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        if (n == 0) return ans;

        int pos = n - 1;
        int i = 0;
        int j = n - 1;
        while (pos >= 0) {
            if (A[i] * A[i] >= A[j] * A[j]) {
                ans[pos] = A[i] * A[i];
                i++;
            } else {
                ans[pos] = A[j] * A[j];
                j--;
            }
            pos--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares1(A)));
    }
}
