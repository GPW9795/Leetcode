package DFS和BFS;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 */
public class _695_岛屿的最大面积_Y {
    int rows;
    int cols;
    int count;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        rows = grid.length;
        cols = grid[0].length;
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                    count = 0;
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int r, int c) {
        // 从岛屿格子走向边界 以及 水域格子
        if (!(r >= 0 && r < rows && c >= 0 && c < cols) || grid[r][c] != 1) {
            return 0;
        }
        // 从岛屿格子走向未遍历过的岛屿格子
        int num = 1;
        // 沉岛思想
        grid[r][c] = 0;
        // 遍历上下左右
        num += dfs(grid, r - 1, c);
        num += dfs(grid, r + 1, c);
        num += dfs(grid, r, c - 1);
        num += dfs(grid, r, c + 1);
        return num;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(new _695_岛屿的最大面积_Y().maxAreaOfIsland(grid));

    }
}
