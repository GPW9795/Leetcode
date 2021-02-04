package A剑指offer;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 */
public class _57_和为s的两个数字_Y {
    /**
     * HashSet
     */
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (set.contains(a)) {
                return new int[]{a, nums[i]};
            }
            set.add(nums[i]);
        }
        return new int[2];
    }

    /**
     * 双指针
     */
    public int[] twoSum1(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int sum = 0;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                break;
            }
        }
        return new int[]{nums[i], nums[j]};
    }
}
