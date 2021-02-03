package 并查集;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/number-of-islands-ii/
 */
public class _305_岛屿数量II_Y {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (positions == null || positions.length == 0 || m == 0 || n == 0) {
            return res;
        }
        // 使用并查集
        UnionFind uf = new UnionFind(m * n);
        for (int[] position : positions) {
            int r = position[0];
            int c = position[1];
            // 当前元素的下标
            int index = r * n + c;
            uf.setParent(index);
            // 判断此格子的上下左右有没有岛屿，如果有的话进行合并
            if (r >= 1 && uf.isValid((r - 1) * n + c)) {
                uf.union(index, (r - 1) * n + c);
            }
            if (r < m - 1 && uf.isValid((r + 1) * n + c)) {
                uf.union(index, (r + 1) * n + c);
            }
            if (c >= 1 && uf.isValid(r * n + (c - 1))) {
                uf.union(index, r * n + (c - 1));
            }
            if (c < n - 1 && uf.isValid(r * n + (c + 1))) {
                uf.union(index, r * n + (c + 1));
            }
            res.add(uf.getCount());
        }
        return res;
    }

    private class UnionFind {
        // 集合数量
        int count;
        // 父节点数组
        int[] parent;
        // 树高数组
        int[] ranks;

        /**
         * 构造函数初始化
         */
        public UnionFind(int n) {
            count = 0;
            parent = new int[n];
            ranks = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = -1;
                ranks[i] = 1;
            }
        }

        /**
         * 获得集合数量
         */
        public int getCount() {
            return count;
        }

        /**
         * 找到元素父节点
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
            int p1 = find(x);
            int p2 = find(y);
            if (p1 == p2) return;

            if (ranks[p1] > ranks[p2]) {
                parent[p2] = p1;
            } else if (ranks[p1] < ranks[p2]) {
                parent[p1] = p2;
            } else {
                parent[p2] = p1;
                ranks[p1]++;
            }
            count--;
        }

        /**
         * 设置父节点
         */
        public void setParent(int x) {
            if (parent[x] == -1) {
                parent[x] = x;
                // 集合数增加
                count++;
            }
        }

        /**
         * 是否为有效元素
         */
        public boolean isValid(int x) {
            return parent[x] >= 0;
        }
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {1, 2}};
        System.out.println(new _305_岛屿数量II_Y().numIslands2(m, n, positions));
    }
}
