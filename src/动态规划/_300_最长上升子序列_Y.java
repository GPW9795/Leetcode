package 动态规划;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class _300_最长上升子序列_Y {
    /**
     * 动态规划
     * dp(i)，表示以nums[i]为结尾的最长上升序列长度
     * 初始值为dp(i) = 1
     * nums[i] > nums[i - 1]: dp(i) = dp(i-1) + 1;
     * nums[i] <= nums[i - 1]: dp(i) = max{dp(i)};
     */
    public int lengthOfL1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        int max = dp[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 二分搜索
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] res = new int[len];
        // 牌堆数量
        int size = 1;
        res[0] = nums[0];
        for (int i = 1; i < len; i++) {
            int begin = 0, end = size;
            while (begin < end) {
                int mid = (begin + end) >> 1;
                if (nums[i] <= res[mid]) {
                    end = mid;
                } else {
                    begin = mid + 1;
                }
            }
            res[begin] = nums[i];
            if (begin == size) {
                size++;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new _300_最长上升子序列_Y().lengthOfLIS(nums));
    }
}
