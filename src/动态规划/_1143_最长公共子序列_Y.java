package 动态规划;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class _1143_最长公共子序列_Y {
    /**
     * 动态规划
     * dp(i, j)为seq1前i个元素和seq2前j个元素的最大公共子序列长度
     * 初始值: dp(i, 0) = dp(0, j) = 0;
     * seq1[i - 1] == seq[j - 1]: dp(i, j) = dp(i - 1, j - 1) + 1;
     * seq1[i - 1] != seq[j - 1]: dp(i, j) = Math.max(dp(i - 1, j),dp(i, j - 1));
     * 最终返回值为dp(i, j)
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // 转为字符数组并做基础判断
        char[] seq1 = text1.toCharArray();
        int len1 = seq1.length;
        if (text1 == null || len1 == 0) return 0;
        char[] seq2 = text2.toCharArray();
        int len2 = seq2.length;
        if (text2 == null || len2 == 0) return 0;

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (seq1[i - 1] == seq2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    /**
     * 优化 - 一维数组
     */
    public int longestCommonSubsequence1(String text1, String text2) {
        // 转为字符数组并做基础判断
        char[] seq1 = text1.toCharArray();
        int len1 = seq1.length;
        if (text1 == null || len1 == 0) return 0;

        char[] seq2 = text2.toCharArray();
        int len2 = seq2.length;
        if (text2 == null || len2 == 0) return 0;

        char[] rows = seq1, cols = seq2;
        if (seq1.length < seq2.length) {
            rows = seq2;
            cols = seq1;
        }
        int[] dp = new int[cols.length + 1];

        for (int i = 1; i <= rows.length; i++) {
            int cur = 0;
            for (int j = 1; j <= cols.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (rows[i - 1] == cols[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[cols.length];
    }

    public String LCS (String str1, String str2) {
        if (str1 == null || str2 == null) return "-1";
        int m = str1.length(), n = str2.length();
        if (m == 0 || n == 0) return "-1";
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0, x = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        x = i;
                    }
                }
            }
        }
        return maxLen == 0 ? "-1" : str1.substring(x - maxLen, x);
    }
}
