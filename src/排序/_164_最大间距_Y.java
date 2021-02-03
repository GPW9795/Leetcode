package 排序;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-gap/
 */
public class _164_最大间距_Y {
    /**
     * 排序.快速排序
     */
    public int maximumGap1(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }

    /**
     * 基数排序
     */
    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        // 求出最大值确定循环次数
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int[] output = new int[n];
        for (int exp = 1; exp <= max; exp *= 10) {
            int[] count = new int[10];
            for (int i = 0; i < n; i++) {
                count[(nums[i] / exp) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                int pos = count[nums[i] / exp % 10] - 1;
                output[pos] = nums[i];
                count[(nums[i] / exp) % 10]--;
            }
            System.arraycopy(output, 0, nums, 0, n);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};
        System.out.println(maximumGap(nums));
    }
}
