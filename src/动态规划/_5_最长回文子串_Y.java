package 动态规划;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class _5_最长回文子串_Y {
    /**
     * 动态规划
     * dp(i, j)是以当前字符i为开头，以j为结尾的字符串是否为最长回文子串
     * s.charAt(i) != s.charAt(j): dp(i, j) = false
     * s.charAt(i) == s.charAt(j): dp(i, j) = dp(i + 1, j - 1)
     * 如果j - i == 0 or 1时，一定为回文子串，dp(i, j) == true
     * 如果j - 1 == i + 1时，一定为回文子串，dp(i + 1, j - 1) == true，j - i == 2
     * 如果j - 1 == i + 1 + 1时，一定为回文子串，dp(i + 1, j - 1) == true，j - i == 3
     * 所以当s.charAt(i) == s.charAt(j)且j - i < 3时，dp(i, j) == true
     * 初始化：对角线的上的值均为true，即i == j时，dp(i, j) == true
     */
    public static String longestPalindrome1(String s) {
        int len = s.length();
        // s为空或者长度小于2时直接返回s
        if (len < 2) {
            return s;
        }
        char[] c = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1, begin = 0;
        // 枚举所有i，j的情况所以i从0开始、len - 2结束，j从i + 1开始、len - 1结束
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (c[i] != c[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 如果dp[i][j] == true且长度大于最大长度记录此时的开始和结束位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 中心扩散法
     * 以每个字符为中心向两边扩散，当回文子串为奇数时中心位置为单个字符，当回文子串为偶数时中心位置为两个一模一样的字符
     * 选择奇数和偶数较长的回文子串进行返回
     */
    static int len;

    public static String longestPalindrome(String s) {
        len = s.length();
        // s为空或者长度小于2时直接返回s
        if (len < 2) {
            return s;
        }
        int maxLen = 0;
        // 结果初始化
        String res = s.substring(0, 1);
        for (int i = 0; i < len - 1; i++) {
            // 奇数回文子串
            String oddStr = centerSpread(s, i, i);
            // 偶数回文子串
            String evenStr = centerSpread(s, i, i + 1);
            // 较长的回文子串
            String maxStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxStr.length() > maxLen) {
                maxLen = maxStr.length();
                res = maxStr;
            }
        }
        return res;
    }

    private static String centerSpread(String s, int left, int right) {
        // left == right 时，回文子串为奇数
        // left + 1 == right 时，回文子串为偶数
        int i = left, j = right;
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 跳出循环时s.charAt(i) != s.charAt(j)，所以要从i + 1开始
        return s.substring(i + 1, j);
    }


    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}

