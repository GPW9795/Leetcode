package 贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class _452_用最少数量的箭引爆气球_Y {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 不直接返回相减的结果怕有溢出
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int end = points[0][1];
        int arrows = 1;
        for (int[] point : points) {
            if (point[0] > end) {
                arrows++;
                end = point[1];
            }
        }
        return arrows;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 6}, {2, 8}, {7, 12}, {10, 16}};
        System.out.println(new _452_用最少数量的箭引爆气球_Y().findMinArrowShots(points));
    }
}
