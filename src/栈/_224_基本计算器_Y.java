package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/basic-calculator/
 */
public class _224_基本计算器_Y {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int flag = 1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            } else if (c == '+') {
                res += flag * num;
                flag = 1;
                num = 0;
            } else if (c == '-') {
                res += flag * num;
                flag = -1;
                num = 0;
            } else if (c == '(') {
                stack.push(res);
                stack.push(flag);
                res = 0;
                flag = 1;
            } else if (c == ')') {
                res += flag * num;
                res *= stack.pop();
                res += stack.pop();
                num = 0;
            }
        }
        return res + (flag * num);
    }
}
