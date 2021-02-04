package A剑指offer;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 */
public class _39_数组中出现次数超过一半的数字_Y {
    /**
     * 自带函数
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 投票
     */
    public int majorityElement1(int[] nums) {
        int x = 0, vote = 0;
        for (int num : nums) {
            if (vote == 0) x = num;
            vote -= num == x ? 1 : -1;
        }
        return x;
    }
}
