package A剑指offer;
import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class _29_顺时针打印矩阵_Y {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int rowBegin = 0, rowEnd = n - 1;
        int colBegin = 0, colEnd = m - 1;
        while (rowBegin <= rowEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                list.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            if (rowBegin > rowEnd) break;

            for (int i = rowBegin; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (colBegin > colEnd) break;

            for (int i = colEnd; i >= colBegin; i--) {
                list.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            if (rowBegin > rowEnd) break;

            for (int i = rowEnd; i >= rowBegin; i--) {
                list.add(matrix[i][colBegin]);
            }
            colBegin++;
            if (colBegin > colEnd) break;
        }
        return list;
    }
}