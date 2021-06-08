package A剑指offer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 */
public class _61_扑克牌中的顺子_Y {
    /**
     * 自己写的
     */
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0) { // 没有任意牌
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1] + 1) continue;
                return false;
            }
            return true;
        } else {
            int zeroCount = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zeroCount++;
                    continue;
                }
                if (i < nums.length - 1 && nums[i + 1] != nums[i] + 1) {
                    if (nums[i + 1] == nums[i]) {
                        return false;
                    }
                    count += nums[i + 1] - nums[i] - 1;
                }
            }
            return zeroCount >= count;
        }
    }

    /**
     * 充分条件
     * （1）牌不重复
     * （2）除去0，Max-Min < 5
     */
    public boolean isStraight1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        int min = 14;
        for (int num : nums) {
            if (num == 0) continue;
            max = Math.max(num, max);
            min = Math.min(num, min);
            if (set.contains(num)) return false;
            set.add(num);
        }
        return max - min < 5;
    }

    /**
     * 排序 + 遍历
     */
    public boolean isStraight2(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[zero] < 5;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 2, 5};
        System.out.println(isStraight(nums));
    }
}
