package A剑指offer;

/**
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class _12_矩阵中的路径_Y {
    int row;
    int col;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j) {
        if (!(0 <= i && i < row && 0 <= j && j < col) || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) return true;
        // 节省遍历的数组空间
        board[i][j] = '\0';
        boolean res = dfs(board, word, index + 1, i - 1, j)
                || dfs(board, word, index + 1, i + 1, j)
                || dfs(board, word, index + 1, i, j - 1)
                || dfs(board, word, index + 1, i, j + 1);
        board[i][j] = word.charAt(index);
        return res;
    }
}
