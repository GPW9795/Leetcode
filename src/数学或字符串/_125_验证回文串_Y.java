package 数学或字符串;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
public class _125_验证回文串_Y {
    /**
     * 不开辟空间
     */
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        s = s.toLowerCase(); // 全部转小写
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            while (!isLetter(arr[i]) && i < j) i++;
            while (!isLetter(arr[j]) && i < j) j--;
            if (i == j) return true;
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean isLetter(char c) {
        return ('a' <= c && c <= 'z') || ('0' <= c && c <= '9');
    }

    /**
     * 利用StringBulider
     */
    public static boolean isPalindrome1(String s) {
        if (s == null || s.length() == 0) return true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(c)); // 转小写
            }
        }
        StringBuilder sb1 = new StringBuilder(sb).reverse();
        return sb.toString().equals(sb1.toString());
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
