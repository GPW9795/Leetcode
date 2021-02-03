package 双指针;

import java.util.Arrays;
import java.util.Iterator;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class _26_删除排序数组中的重复项_Y {
    /**
     * 相等的话j++，不相等的话i++后赋值j当时的元素之后j++
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (nums == null || len < 2) return nums.length;
        int i = 0, j = 1;
        while (i < len && j < len) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }

    public static int removeDuplicates1(int[] nums) {
        int len = nums.length;
        if (nums == null || len < 2) return nums.length;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                if (j - i > 1) {
                    nums[++i] = nums[j];
                }
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }
}
