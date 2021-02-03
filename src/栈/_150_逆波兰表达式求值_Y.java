package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class _150_逆波兰表达式求值_Y {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                int num = 0;
                if (s.equals("+")) {
                    num = a + b;
                } else if (s.equals("-")) {
                    num = b - a;
                } else if (s.equals("*")) {
                    num = a * b;
                } else if (s.equals("/")) {
                    num = b / a;
                }
                stack.push(num);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] s = {"2","1","+","3","*"};
        System.out.println(evalRPN(s));
    }
}
