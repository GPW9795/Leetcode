package 数组或二分查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class _56_合并区间_Y {
    /**
     * 自己写的
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i]);
        }
        int i = 1;
        while (i < list.size()) {
            if (list.get(i)[0] <= list.get(i - 1)[1]) {
                int left = Math.min(list.get(i - 1)[0], list.get(i)[0]);
                int right = Math.max(list.get(i - 1)[1], list.get(i)[1]);
                int[] newElement = {left, right};
                list.set(i, newElement);
                list.remove(i - 1);
            } else {
                i++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    /**
     * 答案
     */
    public static int[][] merge1(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        // 以第一个为基准
        for (int i = 1; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < left) {
                list.add(new int[]{left, right});
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], right);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}};
        System.out.println(Arrays.deepToString(merge1(intervals)));
    }
}
