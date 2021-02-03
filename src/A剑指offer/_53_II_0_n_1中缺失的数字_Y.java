package A剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 */
public class _53_II_0_n_1中缺失的数字_Y {
    /**
     * 二分法
     */
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (nums[mid] == mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }

    /**
     * set集合
     */
    public int missingNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= nums.length; i++) {
            set.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            set.remove(nums[i]);
        }
        int res = 0;
        for (Integer num : set) {
            res = num;
        }
        return res;
    }
}
