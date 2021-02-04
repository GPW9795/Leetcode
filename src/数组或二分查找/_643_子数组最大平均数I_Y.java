package 数组或二分查找;

/**
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/
 */
public class _643_子数组最大平均数I_Y {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return 1.0 * maxSum / k;
    }
}
