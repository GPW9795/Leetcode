package 递归或回溯;

/**
 * https://leetcode-cn.com/problems/n-queens-ii/
 */
public class _52_N皇后II_Y {
    public static void main(String[] args) {
        new _52_N皇后II_Y().totalNQueens(8);
    }
    // 多少种解法
    int ways;

    // 第几列是否有皇后
    boolean[] cols;

    // 对角线上是否有皇后（左上角->右下角）
    boolean[] leftTop;

    // 对角线上是否有皇后（右上角->左下角）
    boolean[] rightTop;

    public int totalNQueens(int n) {
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];
        place(0);
        System.out.println(ways);
        return ways;
    }

    private void place(int row) {
        // 摆放完成
        if (row == cols.length) {
            ways++;
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
}
