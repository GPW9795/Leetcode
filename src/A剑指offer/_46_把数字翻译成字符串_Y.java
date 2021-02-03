package A剑指offer;

/**
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class _46_把数字翻译成字符串_Y {
    /**
     * 采用动态规划，dp[n]表示以n为结尾的数字有多少翻译可能
     * dp[n] = dp[n - 1] + dp[n - 2]，最后两位小于26
     * dp[n] = dp[n - 1]，最后两位大于等于26
     */
    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            String tmp = s.substring(i - 2, i);
            int x = Integer.valueOf(tmp);
            if (x < 26 && !tmp.startsWith("0")) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }

    /**
     * 优化
     */
    public static int translateNum1(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        int a = 1;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            String tmp = s.substring(i - 2, i);
            int x = Integer.valueOf(tmp);
            int c = 9 < x && x < 26 ? a + b : a;
            b = a;
            a = c;

        }
        return a;
    }

    /**
     * 求余
     */

    public static int translateNum2(int num) {
        int a = 1;
        int b = 1;
        int x, y = num % 10;
        while (num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = 9 < tmp && tmp < 26 ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }

    public static void main(String[] args) {
        int num = 506;
        System.out.println(translateNum(num));
    }
}
