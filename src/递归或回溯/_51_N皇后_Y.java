package 递归或回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 */
public class _51_N皇后_Y {

    public static void main(String[] args) {
        new _51_N皇后_Y().solveNQueens(4);
    }

    // 多少种解法
    int ways;

    // 用于打印
    int[] queens;

    // 第几列是否有皇后
    boolean[] cols;

    // 对角线上是否有皇后（左上角->右下角）
    boolean[] leftTop;

    // 对角线上是否有皇后（右上角->左下角）
    boolean[] rightTop;

    // 存放结果的列表
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        queens = new int[n];
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];
        result = new ArrayList<>();
        place(0);
        System.out.println(result);
        return result;
    }

    /**
     * 摆放第几行皇后
     */
    private void place(int row) {
        // 摆放完成
        if (row == cols.length) {
            ways++;
            result.add(show());
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            // 判断此行此列是否可以摆放皇后
            if (cols[col]) continue;
            int ltIndex = row - col + cols.length - 1;
            if (leftTop[ltIndex]) continue;
            int rtIndex = row + col;
            if (rightTop[rtIndex]) continue;

            // 此位置可以摆放皇后
            queens[row] = col;
            cols[col] = true;
            leftTop[ltIndex] = true;
            rightTop[rtIndex] = true;

            // 开始摆放下一列
            place(row + 1);

            // 如果到这里说明下一列摆放失败，重置三个数组的布尔值
            cols[col] = false;
            leftTop[ltIndex] = false;
            rightTop[rtIndex] = false;
        }
    }

    /**
     * 拼接字符串
     */
    private List<String> show() {
        List<String> list = new ArrayList<>();
        for (int row = 0; row < cols.length; row++) {
            // 清空字符串
            String str = new String();
            for (int col = 0; col < cols.length; col++) {
                if (col == queens[row]) {
                    str += "Q";
                } else {
                    str += ".";
                }
            }
            list.add(str);
        }
        return list;
    }
}
