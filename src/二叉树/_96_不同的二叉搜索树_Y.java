package 二叉树;

import java.awt.desktop.PrintFilesEvent;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class _96_不同的二叉搜索树_Y {
    /**
     * 动态规划实现
     * 假设f(i)为以i为根节点的BST个数，G(n)为从1~n的BST总个数，G(n) = f(1) + f(2) + ... + f(n)
     * 当i为根节点时，G(i - 1)为前i - 1个节点的总BST个数
     * G(n - i)为后n - i个节点的总BST个数
     * 所以f(i) = G(i - 1) * G(n - i)
     * 所以G(n) = ∑(i = 1~n) G(i - 1) * G(n - i)
     * 设dp(i)为1~i的BST总个数，dp(i) = ∑(j = 1~i) G(j - 1) * G(i - j)
     * 初始值dp(0) = dp(1) = 1
     * 时间复杂度为O(n^2)，空间复杂度为O(n)
     */
    public int numTrees(int n) {
        if (n < 2) return 1;
        int[] dp = new int[n + 1];
        // 初始值
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    /**
     * 数学法直接计算，本质为卡塔兰数
     * C0 = 1，Cn+1 = 2(2n+1)/n+2 * Cn
     */
    public int numTrees1(int n) {
        if (n < 2) return 1;
        // long类型防止溢出
        long c = 1;
        for (int i = 1; i < n; i++) {
            c = c * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) c;
    }
}
