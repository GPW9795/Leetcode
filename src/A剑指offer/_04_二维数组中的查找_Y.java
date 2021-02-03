package A剑指offer;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
public class _04_二维数组中的查找_Y {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int nn = n - 1;
        int mm = 0;
        while (nn >= 0 && mm < m) {
            if (target < matrix[nn][mm]) {
                nn -= 1;
            } else if (target > matrix[nn][mm]) {
                mm += 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
