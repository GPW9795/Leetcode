package 动态规划;

/**
 * https://leetcode-cn.com/problems/house-robber/
 */
public class _198_打家劫舍_Y {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int a = 0;
        int b = nums[0];
        int sum = b;
        for (int i = 1; i < n; i++) {
            sum = Math.max(b, a + nums[i]);
            a = b;
            b = sum;
        }
        return sum;
    }
}
