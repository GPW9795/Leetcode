package 数学或字符串;

/**
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 */
public class _680_验证回文字符II_Y {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() < 3) return true;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return validPalindromeHelper(s, i + 1, j) || validPalindromeHelper(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 判断在字符串s从left到right间是否为回文字符串
     */
    private boolean validPalindromeHelper(String s, int left, int right) {
        if (right == left) return true;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
