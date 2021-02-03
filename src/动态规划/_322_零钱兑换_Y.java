package 动态规划;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 */
public class _322_零钱兑换_Y {
    /**
     * 动态规划
     * dp(i)表示当amount为i时所需的最少硬币数
     * dp(face) = 1, face为不同面值, dp(0) = 0
     * dp(i) = min{dp(i - face)} + 1, 前提是i >= face
     * 最终返回值为dp(amount)
     */
    public int coinChange1(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin) continue;
                if (dp[i - coin] < 0 || dp[i - coin] >= min) continue;
                min = dp[i - coin];
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[amount];
    }

    /**
     * 贪心 + 回溯 + 剪枝
     */
    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        Arrays.sort(coins);
        minCoinsNum(coins, amount, coins.length - 1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void minCoinsNum(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }
        if (index < 0) {
            return;
        }
        for (int i = amount / coins[index]; i >= 0 && i + count < res; i--) {
            minCoinsNum(coins, amount-(i * coins[index]), index - 1, count + i);
        }
    }
}
