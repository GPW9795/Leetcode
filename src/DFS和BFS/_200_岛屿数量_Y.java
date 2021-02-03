package DFS和BFS;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class _200_岛屿数量_Y {
    /**
     * 深度优先遍历
     */
    int rows;
    int cols;

    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        rows = grid.length;
        cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (!(r >= 0 && r < rows && c >= 0 && c < cols) || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    /**
     * 使用并查集实现
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        rows = grid.length;
        cols = grid[0].length;
        UnionFind uf = new UnionFind(rows * cols);
        // 水域的数量
        int spaces = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0') {
                    spaces++;
                } else { // 此时为岛屿格子，判断其上下左右
                    int index = i * cols + j; // 当前岛屿格子的下标
                    if (i >= 1 && grid[i - 1][j] == '1') {
                        uf.union(index, (i - 1) * cols + j);
                    }
                    if (i < rows - 1 && grid[i + 1][j] == '1') {
                        uf.union(index, (i + 1) * cols + j);
                    }
                    if (j >= 1 && grid[i][j - 1] == '1') {
                        uf.union(index, i * cols + (j - 1));
                    }
                    if (j < cols - 1 && grid[i][j + 1] == '1') {
                        uf.union(index, i * cols + (j + 1));
                    }
                }
            }
        }
        return uf.getCount() - spaces;
    }

    private class UnionFind {
        int count; // 集合的数量
        int[] parent; // 每个元素的父节点下标
        int[] rank; // 基于rank的优化

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        /**
         * 返回集合数量
         */
        public int getCount() {
            return count;
        }

        /**
         * 查找两个元素，并做路径减半
         */
        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        /**
         * 合并两个元素
         */
        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;

            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[py] = px;
                rank[px]++;
            }
            count--;
        }
    }

    /**
     * 主函数
     */
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}};
        System.out.println(new _200_岛屿数量_Y().numIslands(grid));
    }
}
