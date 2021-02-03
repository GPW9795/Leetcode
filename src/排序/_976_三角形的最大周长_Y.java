package 排序;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/largest-perimeter-triangle/
 */
public class _976_三角形的最大周长_Y {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }
}
