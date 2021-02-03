package DFS和BFS;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/number-of-distinct-islands/
 */
public class _694_不同岛屿的数量_Y {
    static int rows;
    static int cols;

    public static int numDistinctIslands(int[][] grid) {
        if (grid.length == 0) return 0;
        rows = grid.length;
        cols = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(sb, grid, i, j, i, j);
                    System.out.println(sb.toString());
                    set.add(sb.toString());
                }
            }
        }
        // 最后返回集合数量
        return set.size();
    }

    /**
     * 以原始坐标为(0,0)， 记录每个坐标的相对原始坐标的位置拼接成字符串，字符串一样则相等
     */
    private static void dfs(StringBuilder sb, int[][] grid, int r, int c, int originR, int originC) {
        if (!(r >= 0 && r < rows && c >= 0 && c < cols) || grid[r][c] == 0) {
            return;
        }
        sb.append(r - originR).append(c - originC);
        grid[r][c] = 0;
        dfs(sb, grid, r - 1, c, originR, originC); // 上
        dfs(sb, grid, r + 1, c, originR, originC); // 下
        dfs(sb, grid, r, c - 1, originR, originC); // 左
        dfs(sb, grid, r, c + 1, originR, originC); // 右
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};
        System.out.println(numDistinctIslands(grid));
    }
}
