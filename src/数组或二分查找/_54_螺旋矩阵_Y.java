package 数组或二分查找;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class _54_螺旋矩阵_Y {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rowBegin = 0, rowEnd = rows - 1;
        int colBegin = 0, colEnd = cols - 1;
        while (rowBegin <= rowEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            if (rowBegin > rowEnd) break;

            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (colBegin > colEnd) break;

            for (int i = colEnd; i >= colBegin; i--) {
                res.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            if (rowBegin > rowEnd) break;

            if (rowBegin <= rowEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
            if (colBegin > colEnd) break;
        }
        return res;
    }
}
