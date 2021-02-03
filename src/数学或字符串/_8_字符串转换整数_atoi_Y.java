package 数学或字符串;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class _8_字符串转换整数_atoi_Y {
    /**
     * 正则表达式
     */
    public static int myAtoi(String s) {
        s = s.trim(); // 去掉多余空格
        if (s == null || s.length() == 0) {
            return 0;
        }
        Pattern pattern = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher matcher = pattern.matcher(s);

        int value = 0;
        if (matcher.find()) {
            try {
                value = Integer.parseInt(s.substring(matcher.start(), matcher.end()));
            } catch (Exception e) {
                value = s.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

        }
        return value;
    }

    /**
     * 正常流程判断
     */
    public static int myAtoi1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        char[] chars = s.toCharArray();
        int index = 0;
        // 去除空格
        while (index < len && chars[index] == ' ') {
            index++;
        }
        // 极端情况全是空格
        if (index == len) {
            return 0;
        }
        // 判断第一个字符是符号还是其他
        int sign = 1;
        if (chars[index] == '-') {
            sign = -1;
            index++;
        } else if (chars[index] == '+') {
            index++;
        }
        // 开始遍历剩下的数字
        int ans = 0;
        while (index < len) {
            char c = chars[index++];
            if (c < '0' || c > '9') break;
            int pop = sign * (c - '0');
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) return Integer.MAX_VALUE;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) return Integer.MIN_VALUE;
            ans = ans * 10 + pop;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "-2147483649";
        System.out.println(myAtoi1(s));
    }
}
