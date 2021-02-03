package 栈;

import java.util.Stack;

public class 表达式求值_Y {
    public int solve (String s) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        char sign = '+';
        int num = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            }
            if (c == '(') {
                int par = 1;
                int j = i + 1;
                while (par > 0) {
                    if (arr[j] == '(') {
                        par++;
                    } else if (arr[j] == ')') {
                        par--;
                    }
                    j++;
                }
                String sub = s.substring(i + 1, j);
                num = solve(sub);
                i = j - 1;
            }
            if (!Character.isDigit(c) || i == n - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-1 * num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
