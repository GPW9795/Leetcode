package 数学或字符串;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class _9_回文数_Y {
    /**
     * 转为字符串
     */
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        StringBuilder str_1 = new StringBuilder(str);
        StringBuilder str_2 = new StringBuilder(str).reverse();
        for (int i = 0; i < str.length(); i++) {
            if (str_1.charAt(i) != str_2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 不转为字符串
     */
    public boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rev = 0;
        int num = x;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev == x;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev / 10;
    }
}