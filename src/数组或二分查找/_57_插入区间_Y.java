package 数组或二分查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/insert-interval/
 */
public class _57_插入区间_Y {
    /**
     * 自己写的
     */
    public static int[][] insert1(int[][] intervals, int[] newInterval) {
        // 先比较第一个数，判断插入位置
        List<int[]> list = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= newInterval[0] && flag) {
                flag = false;
                list.add(newInterval);
            }
            list.add(intervals[i]);
        }
        if (flag == true) {
            list.add(newInterval);
        }

        int i = 1;
        while (i < list.size()) {
            if (list.get(i)[0] <= list.get(i - 1)[1]) {
                if (list.get(i)[1] <= list.get(i - 1)[1]) {
                    int[] newElement = {list.get(i - 1)[0], list.get(i - 1)[1]};
                    list.set(i - 1, newElement);
                    list.remove(i);
                } else {
                    int[] newElement = {list.get(i - 1)[0], list.get(i)[1]};
                    list.set(i - 1, newElement);
                    list.remove(i);
                }
            } else {
                i++;
            }
        }
        int[][] res = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
        }
        return res;
    }

    /**
     * 答案思路
     * 遍历一遍，将新的区间拆为边值，left和right
     * 遍历时比较二维数组中的边值与left和right的关系并进行相关操作
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean flag = true;
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) { // 区间在新区间的右侧，无重叠，此时应该插入新区间
                if (flag) {
                    flag = false;
                    list.add(new int[]{left, right});
                }
                list.add(interval);
            } else if (interval[1] < left) { // 区间在新区间的左侧，无重叠
                list.add(interval);
            } else { // 说明区间有重叠
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (flag) {
            list.add(new int[]{left, right});
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 7};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

}
