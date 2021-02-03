package 排序;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 */
public class _315_计算右侧小于当前元素的个数 {
    /**
     * 暴力法，超出时间限制
     */
    public List<Integer> countSmaller1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            list.add(count);
        }
        return list;
    }

    /**
     *
     */
    public List<Integer> countSmaller(int[] nums) {
        return null;
    }
}
