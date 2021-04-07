package A剑指offer;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */
public class _58_I_翻转单词顺序_Y {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    // 自己写的
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        Stack<String> stack = new Stack<>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c != ' ') {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    stack.push(sb.toString());
                    sb.delete(0, sb.length());
                }
            }
        }
        if (sb.length() > 0) {
            stack.push(sb.toString());
            sb.delete(0, sb.length());
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }
        return sb.toString().trim();
    }


    public String reverseWords1(String s) {
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }
}
