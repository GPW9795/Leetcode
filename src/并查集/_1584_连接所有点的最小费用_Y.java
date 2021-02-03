package 并查集;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/min-cost-to-connect-all-points/
 */
public class _1584_连接所有点的最小费用_Y {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(minCostConnectPoints(points));
    }

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // 初始化并查集
        UnionFind uf = new UnionFind(n);
        // 初始化所有边
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(i, j, weight(points[i], points[j])));
            }
        }
        Collections.sort(edges, (a, b) -> a.weight - b.weight);

        // 开始选择最小边
        int res = 0;
        for (Edge edge : edges) {
            if (uf.count == 1) break;
            if (uf.find(edge.start) == uf.find(edge.end)) continue;
            uf.union(edge.start, edge.end);
            res += edge.weight;
        }

        return res;
    }

    public static int weight(int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static class UnionFind {
        int[] parent;
        int[] rank;
        // 集合数量
        int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;

            count--;
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }
}
