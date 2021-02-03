package 动态规划;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class _121_买卖股票的最佳时机_Y {
    /**
     * 动态规划
     * 表示前i天获得的最大利润，最后返回dp[n - 1]
     */
    public int maxProfit(int[] prices) {
        int dayNum = prices.length;
        if (prices == null || dayNum == 0) return 0;
        int[] dp = new int[dayNum];
        dp[0] = 0;
        int minPrice = prices[0];
        for (int i = 1; i < dayNum; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }
        return dp[dayNum - 1];
    }

    /**
     * 优化
     */
    public int maxProfit1(int[] prices) {
        int dayNum = prices.length;
        if (prices == null || dayNum == 0) return 0;
        int dp = 0;
        int minPrice = prices[0];
        for (int i = 1; i < dayNum; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (dp < (prices[i] - minPrice)) {
                dp = prices[i] - minPrice;
            }
        }
        return dp;
    }
}
