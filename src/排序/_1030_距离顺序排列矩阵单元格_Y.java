package 排序;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 */
public class _1030_距离顺序排列矩阵单元格_Y {
    /**
     * 自己写的，效率低
     */
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int n = R * C;
        int[][] arr = new int[n][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i * C + j] = new int[]{i, j};
            }
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int dist1 = Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0);
                int dist2 = Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0);
                return dist1 - dist2;
            }
        });
        return arr;
    }

    /**
     * BFS，效率很高
     */
    public static int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        //结果数组和开始索引
        int n = R * C;
        int[][] res = new int[n][2];
        boolean[] pos = new boolean[n];
        int index = 0;
        // 方向数组
        int[] direr = {0, 0, -1, 1};
        int[] direc = {1, -1, 0, 0};
        // 队列初始值
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r0, c0});
        pos[r0 * C + c0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            // 放入结果数组中
            res[index++] = cur;
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < 4; i++) {
                int row = r + direr[i];
                int col = c + direc[i];
                if (0 <= row && row < R && 0 <= col && col < C) {
                    if (!pos[row * C + col]) {
                        queue.offer(new int[]{row, col});
                        pos[row * C + col] = true;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 桶排序
     */
    public static int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        int n = R * C;
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        List<List<int[]>> bucket = new LinkedList<>();
        // 新建maxDist个桶
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new LinkedList<int[]>());
        }
        // 插入不同的桶中
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int dist = dist(r0, c0, i, j);
                bucket.get(dist).add(new int[]{i, j});
            }
        }
        // 遍历桶
        int[][] res = new int[n][2];
        int idx = 0;
        for (int i = 0; i <= maxDist; i++) {
            for (int[] arr : bucket.get(i)) {
                res[idx++] = arr;
            }
        }
        return res;
    }

    private static int dist(int r0, int c0, int i, int j) {
        return Math.abs(i - r0) + Math.abs(j - c0);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(allCellsDistOrder1(2, 3, 1, 2)));
    }
}
