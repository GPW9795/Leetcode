package 动态规划;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class _53_最大子序和_Y {
    /**
     * 动态规划
     */
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    /**
     * 分治解法
     * 最大子序列和可能有三种：
     * （1）在[begin, mid)中
     * （2）在[mid, end)中
     * （3）在[i, mid)和[mid,j)中，从mid往左扫描到和的最大值， 往右扫描到最大值合并
     */
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return maxSubArray(nums, 0, nums.length);
    }

    private int maxSubArray(int[] nums, int begin, int end) {
        // 如果只剩一个元素，则最大子序列和为他自己
        if (end - begin < 2) return nums[begin];
        // 中间值的下标
        int mid = (begin + end) >> 1;
        // 按第三种情况算最大子序列和
        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid - 1; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        int max = leftMax + rightMax;
        return Math.max(max,
                Math.max(
                        maxSubArray(nums, begin, mid), // 左边序列最大值
                        maxSubArray(nums, mid, end) // 右边序列最大值
                )
        );
    }

    /**
     * 动态规划 + 滚动数组
     * dp(i)表示以nums[i]为结尾的最大子序列和
     * dp(i-1) <= 0: dp(i) = nums[i]
     * dp(i-1) > 0: dp(i) = dp(i - 1) + nums[i]
     */
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[2];
        int max = dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            int prev = (i - 1) & 1;
            int cur = i & 1;
            if (dp[prev] <= 0) {
                dp[cur] = nums[i];
            } else {
                dp[cur] = dp[prev] + nums[i];
            }
            max = Math.max(max, dp[cur]);
        }
        return max;
    }

    /**
     * 针对以上的优化
     */
    public int maxSubArray3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            if (dp <= 0) {
                dp = nums[i];
            } else {
                dp += nums[i];
            }
            max = Math.max(max, dp);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new _53_最大子序和_Y().maxSubArray3(nums));
    }
}
