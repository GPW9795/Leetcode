package 数组或二分查找;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class _240_搜索二维矩阵II_Y {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int nn = n - 1;
        int m = matrix[0].length;
        int mm = 0;
        while (nn >= 0 && mm < m) {
            if (matrix[nn][mm] > target) {
                nn--;
            } else if (matrix[nn][mm] < target) {
                mm++;
            } else {
                return true;
            }
        }
        return false;
    }
}
