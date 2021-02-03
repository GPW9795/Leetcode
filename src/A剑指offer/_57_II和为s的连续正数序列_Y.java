package A剑指offer;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 */
public class _57_II和为s的连续正数序列_Y {
    /**
     * 滑动窗口
     */
    public int[][] findContinuousSequence(int target) {
        int max = target / 2;
        int l = 1, r = 1;
        int sum = 0;
        List<int[]> res = new LinkedList<>();
        while (l <= max) {
            if (sum < target) {
                sum += r;
                r++;
            } else if (sum > target) {
                sum -= l;
                l++;
            } else {
                int[] arr = new int[r - l];
                for (int i = l; i < r; i++) {
                    arr[i - l] = i;
                }
                res.add(arr);
                sum -= l;
                l++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
