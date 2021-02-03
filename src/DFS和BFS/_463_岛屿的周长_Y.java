package DFS和BFS;

/**
 * https://leetcode-cn.com/problems/island-perimeter/
 */
public class _463_岛屿的周长_Y {
    /**
     * 利用相临边和总边的关系
     */
    public int islandPerimeter1(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        // 格子的数量
        int count = 0;
        // 相邻边的数量
        int edges = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                count++;
                if (j < n - 1 && grid[i][j + 1] == 1) {
                    edges++;
                }
                if (i < m - 1 && grid[i + 1][j] == 1) {
                    edges++;
                }
            }
        }
        return 4 * count - 2 * edges;
    }

    /**
     * DFS
     */

    int rows;
    int cols;

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    /**
     * 深度优先遍历，每次都是从岛屿格子往外走，r为行，c为列
     */
    private int dfs(int[][] grid, int r, int c) {
        // 从岛屿格子走向边界
        if (!(r >= 0 && r < rows && c >= 0 && c < cols)) {
            return 1;
        }
        // 从岛屿格子走向水域格子
        if (grid[r][c] == 0) {
            return 1;
        }
        // 从岛屿格子走向已遍历过的岛屿格子
        if (grid[r][c] != 1) {
            return 0;
        }
        // 从岛屿格子走向未遍历过的岛屿格子
        grid[r][c] = 2;
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        System.out.println(new _463_岛屿的周长_Y().islandPerimeter(grid));
    }
}
