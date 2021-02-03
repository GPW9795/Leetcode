package 数组或二分查找;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 */
public class _31_下一个排列_Y {
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        // 从后往前找到第一个升序对并记录位置
        int left = -1, right = len - 1;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                left = i - 1;
                break;
            }
        }
        //不是完全逆序的情况
        if (left != -1) {
            // 再从right位置往后找，找到最后一个大于left位置元素的值
            for (int i = left + 1; i < len; i++) {
                if (nums[i] <= nums[left]) {
                    right = i - 1;
                    break;
                }
            }
            // 交换left和right位置的元素
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        // 从left后面开始逆序
        Arrays.sort(nums, left + 1, len);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
